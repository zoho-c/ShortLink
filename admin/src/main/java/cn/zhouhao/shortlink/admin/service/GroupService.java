package cn.zhouhao.shortlink.admin.service;

import cn.zhouhao.shortlink.admin.dao.entity.GroupDO;
import cn.zhouhao.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import cn.zhouhao.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import cn.zhouhao.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author hiroshi
 * @version 1.0
 */
public interface GroupService extends IService<GroupDO> {


    /**
     * 创建短链接分组
     *
     * @param groupName 短链接分组名
     */
    void saveGroup(String groupName);

    /**
     * 获取用户短链接分组列表
     *
     * @return 短链接分组列表
     */
    List<ShortLinkGroupRespDTO> listGroup();

    /**
     * 删除短链接分组
     *
     * @param gid 短链接分组标识
     */
    void deleteGroup(String gid);

    /**
     * 更新短链接分组
     *
     * @param requestParam 更新短链接分组请求参数
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    /**
     * 短链接分组排序
     *
     * @param requestParam 短链接分组排序参数
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}
