package cn.zhouhao.shortlink.admin.dto.req;

import lombok.Data;

/**
 * 短链接分组排序参数
 *
 * @author hiroshi
 * @version 1.0
 */
@Data
public class ShortLinkGroupSortReqDTO {
    /**
     * 分组ID
     */
    private String gid;

    /**
     * 排序
     */
    private Integer sortOrder;
}
