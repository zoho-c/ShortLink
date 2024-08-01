package cn.zhouhao.shortlink.project.dto.req;

import cn.zhouhao.shortlink.project.dao.entity.ShortLinkDO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * @author hiroshi
 * @version 1.0
 */
@Data
public class ShortLinkPageReqDTO extends Page<ShortLinkDO> {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 排序标识
     */
    private String orderTag;
}
