package cn.zhouhao.shortlink.project.service;

import cn.zhouhao.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

/**
 * @author hiroshi
 * @version 1.0
 */
public interface ShortLinkStatsService {
    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam 获取短链接监控数据入参
     * @return 短链接监控数据
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);
}
