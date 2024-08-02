package cn.zhouhao.shortlink.project.service;

import cn.zhouhao.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkStatsRespDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     *
     * @param requestParam 获取短链接监控访问记录数据入参
     * @return 访问记录监控数据
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);
}
