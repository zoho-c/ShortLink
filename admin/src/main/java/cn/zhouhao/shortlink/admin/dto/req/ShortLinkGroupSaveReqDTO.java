package cn.zhouhao.shortlink.admin.dto.req;

import lombok.Data;

/**
 * 短链接分组创建参数
 *
 * @author hiroshi
 * @version 1.0
 */
@Data
public class ShortLinkGroupSaveReqDTO {
    /**
     * 分组名
     */
    private String name;
}
