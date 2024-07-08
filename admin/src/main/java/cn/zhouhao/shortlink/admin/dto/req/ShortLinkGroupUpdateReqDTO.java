package cn.zhouhao.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author hiroshi
 * @version 1.0
 */
@Data
public class ShortLinkGroupUpdateReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名
     */
    private String name;
}
