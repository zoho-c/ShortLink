package cn.zhouhao.shortlink.admin.service.impl;

import cn.zhouhao.shortlink.admin.common.convention.exception.ClientException;
import cn.zhouhao.shortlink.admin.common.enums.UserErrorCodeEnum;
import cn.zhouhao.shortlink.admin.dao.entity.UserDO;
import cn.zhouhao.shortlink.admin.dao.mapper.UserMapper;
import cn.zhouhao.shortlink.admin.dto.resp.UserRespDTO;
import cn.zhouhao.shortlink.admin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 * @author hiroshi
 * @version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    public UserRespDTO getUserByUserName(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class).eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (userDO == null) {
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
        UserRespDTO userRespDTO = new UserRespDTO();

        BeanUtils.copyProperties(userDO, userRespDTO);

        return userRespDTO;
    }
}
