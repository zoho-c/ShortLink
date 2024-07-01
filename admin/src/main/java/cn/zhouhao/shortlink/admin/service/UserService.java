package cn.zhouhao.shortlink.admin.service;

import cn.zhouhao.shortlink.admin.dao.entity.UserDO;
import cn.zhouhao.shortlink.admin.dto.req.UserLoginReqDTO;
import cn.zhouhao.shortlink.admin.dto.req.UserRegisterReqDTO;
import cn.zhouhao.shortlink.admin.dto.req.UserUpdateReqDTO;
import cn.zhouhao.shortlink.admin.dto.resp.UserLoginRespDTO;
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

    /**
     * 根据用户名更新用户信息
     *
     * @param requestParam
     */
    void update(UserUpdateReqDTO requestParam);

    /**
     * 用户登录
     *
     * @param requestParam 用户登录请求参数
     * @return 用户登录返回参数 Token
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    Boolean checkLogin(String username, String token);

    /**
     * 退出登录
     *
     * @param username 用户名
     * @param token    用户Token
     */
    void logout(String username, String token);
}
