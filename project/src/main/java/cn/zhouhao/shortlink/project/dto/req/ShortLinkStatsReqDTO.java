package cn.zhouhao.shortlink.project.dto.req;

import lombok.Data;

/**
 * @author hiroshi
 * @version 1.0
 */
@Data
public class ShortLinkStatsReqDTO {
    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
}
