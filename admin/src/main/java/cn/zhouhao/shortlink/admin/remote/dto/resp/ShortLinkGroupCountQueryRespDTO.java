package cn.zhouhao.shortlink.admin.remote.dto.resp;

import lombok.Data;

/**
 * @author hiroshi
 * @version 1.0
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {
    /**
     * 需要查询的gid
     */
    private String gid;

    /**
     * gid下对应的短链接数量
     */
    private Integer shortLinkCount;
}
