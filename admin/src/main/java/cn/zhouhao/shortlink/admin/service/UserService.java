package cn.zhouhao.shortlink.admin.service;

import cn.zhouhao.shortlink.admin.dao.entity.UserDO;
import cn.zhouhao.shortlink.admin.dto.req.UserRegisterReqDTO;
import cn.zhouhao.shortlink.admin.dto.resp.UserRespDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户接口层
 *
 * @author hiroshi
 * @version 1.0
 */
public interface UserService extends IService<UserDO> {
    UserRespDTO getUserByUserName(String username);

    /**
     * 查看用户名是否已经存在
     *
     * @param username 用户名
     * @return true:存在 false:不存在
     */
    boolean hasUserName(String username);

    void register(UserRegisterReqDTO requestParam);
}
