package cn.zhouhao.shortlink.project.service;

import cn.zhouhao.shortlink.project.dao.entity.ShortLinkDO;
import cn.zhouhao.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author hiroshi
 * @version 1.0
 */
public interface RecycleBinService extends IService<ShortLinkDO> {

    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    /**
     * 分页查询短链接
     *
     * @param requestParam 分页查询短链接请求参数
     * @return 短链接分页返回结果
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam);
}

