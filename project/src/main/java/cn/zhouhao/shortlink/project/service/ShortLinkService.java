package cn.zhouhao.shortlink.project.service;

import cn.zhouhao.shortlink.project.dao.entity.ShortLinkDO;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkBatchCreateReqDTO;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkPageReqDTO;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkBatchCreateRespDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.util.List;

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

    /**
     * 分页查询短链接
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * 批量查询gid中的短链接数量
     *
     * @param requestParam 需要查询的gid
     * @return 每个gid对应的短链接数量
     */
    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);

    /**
     * 更新短链接
     *
     * @param requestParam 更新短链接请求参数
     */
    void updateShortLink(ShortLinkUpdateReqDTO requestParam);

    /**
     * 短链接跳转
     *
     * @param shortUri 短链接后缀
     * @param request  HTTP 请求
     * @param response HTTP 响应
     */
    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);


    /**
     * 短链接访问统计
     *
     * @param fullShortUri 短链接
     * @param request      HTTP 请求
     * @param response     HTTP 响应
     */
    void shortLinkStats(String fullShortUri, String gid, ServletRequest request, ServletResponse response);

    ShortLinkBatchCreateRespDTO batchCreateShortLink(ShortLinkBatchCreateReqDTO requestParam);
}
