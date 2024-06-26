package cn.zhouhao.shortlink.admin.service;

import cn.zhouhao.shortlink.admin.dao.entity.UserDO;
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
}
