package cn.zhouhao.shortlink.project.mq.consumer;

import cn.zhouhao.shortlink.project.dto.riz.ShortLinkStatsRecordDTO;
import cn.zhouhao.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

import static cn.zhouhao.shortlink.project.common.constant.RedisKeyConstant.DELAY_QUEUE_STATS_KEY;

@Component
@RequiredArgsConstructor
public class DelayShortLinkStatsConsumer implements InitializingBean {
    private final RedissonClient redissonClient;
    private final ShortLinkService shortLinkService;

    public void onMessage() {
        Executors.newSingleThreadExecutor(
                runnable -> {
                    Thread thread = new Thread(runnable);
                    thread.setName("delay-short-link-stats-consumer");
                    thread.setDaemon(Boolean.TRUE);
                    return thread;
                }
        ).execute(() -> {
            RBlockingDeque<ShortLinkStatsRecordDTO> blockingDeque = redissonClient.getBlockingDeque(DELAY_QUEUE_STATS_KEY);
            RDelayedQueue<ShortLinkStatsRecordDTO> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
            for (; ; ) {
                try {
                    ShortLinkStatsRecordDTO statsRecord = delayedQueue.poll();
                    if (statsRecord != null) {
                        shortLinkService.shortLinkStats(null, null, statsRecord);
                        continue;
                    }
                    LockSupport.parkUntil(500);
                } catch (Throwable ignored) {

                }
            }
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        onMessage();
    }
}
