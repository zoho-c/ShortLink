package cn.zhouhao.shortlink.project.dto.req;

import lombok.Data;

/**
 * @author hiroshi
 * @version 1.0
 */
@Data
public class RecycleBinSaveReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 完整短链接
     */
    private String fullShortUrl;
}
