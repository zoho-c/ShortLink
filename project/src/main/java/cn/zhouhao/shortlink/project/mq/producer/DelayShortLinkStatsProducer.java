package cn.zhouhao.shortlink.project.mq.producer;

import cn.zhouhao.shortlink.project.dto.riz.ShortLinkStatsRecordDTO;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static cn.zhouhao.shortlink.project.common.constant.RedisKeyConstant.DELAY_QUEUE_STATS_KEY;

@Component
@RequiredArgsConstructor
public class DelayShortLinkStatsProducer {
    private final RedissonClient redissonClient;

    /**
     * send delay message of the statistics of the short link
     */
    public void send(ShortLinkStatsRecordDTO statsRecord) {
        RBlockingDeque<ShortLinkStatsRecordDTO> blockingDeque = redissonClient.getBlockingDeque(DELAY_QUEUE_STATS_KEY);
        RDelayedQueue<ShortLinkStatsRecordDTO> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
        delayedQueue.offer(statsRecord, 5, TimeUnit.SECONDS);
    }
}
