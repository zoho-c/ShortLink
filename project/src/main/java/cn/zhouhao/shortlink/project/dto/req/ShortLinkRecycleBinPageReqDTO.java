package cn.zhouhao.shortlink.project.dto.req;

import cn.zhouhao.shortlink.project.dao.ShortLinkDO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author hiroshi
 * @version 1.0
 */
public class ShortLinkRecycleBinPageReqDTO extends Page<ShortLinkDO> {
    /**
     * 分组标识
     */
    private List<String> gidList;
}
