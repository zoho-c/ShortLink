package cn.zhouhao.shortlink.project.service;

import cn.zhouhao.shortlink.project.dao.ShortLinkDO;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author hiroshi
 * @version 1.0
 */
public interface ShortLinkService extends IService<ShortLinkDO> {
    /**
     * 创建短链接
     *
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建信息
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);
}
