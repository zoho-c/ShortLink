package cn.zhouhao.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.zhouhao.shortlink.admin.common.convention.exception.ClientException;
import cn.zhouhao.shortlink.admin.common.enums.UserErrorCodeEnum;
import cn.zhouhao.shortlink.admin.dao.entity.UserDO;
import cn.zhouhao.shortlink.admin.dao.mapper.UserMapper;
import cn.zhouhao.shortlink.admin.dto.req.UserRegisterReqDTO;
import cn.zhouhao.shortlink.admin.dto.resp.UserRespDTO;
import cn.zhouhao.shortlink.admin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

import static cn.zhouhao.shortlink.admin.common.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;
import static cn.zhouhao.shortlink.admin.common.enums.UserErrorCodeEnum.USER_NAME_EXIST;

/**
 * @author hiroshi
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

    private final RedissonClient redissonClient;

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

    @Override
    public boolean hasUserName(String username) {
        return userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {
        if (hasUserName(requestParam.getUsername())) {
            throw new ClientException(USER_NAME_EXIST);
        }
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY + requestParam.getUsername());

        if (!lock.tryLock()) {
            throw new ClientException(USER_NAME_EXIST);
        }

        try {
            int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
            if (inserted < 1) {
                throw new ClientException(UserErrorCodeEnum.USER_SAVE_ERROR);
            }
            userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
        } finally {
            lock.unlock();
        }
    }
}
