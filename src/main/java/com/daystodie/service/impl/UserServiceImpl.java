package com.daystodie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.daystodie.entity.User;
import com.daystodie.entity.vo.HoldUserVo;
import com.daystodie.exception.BaseException;
import com.daystodie.exception.BaseExceptionEnum;
import com.daystodie.mapper.UserMapper;
import com.daystodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService的实现类
 *
 * @author leaf
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 获取当前用户已有的mod实现方法
     *
     * @param steamId      当前用户的steamId
     * @param userQq       当前用户的qq
     * @param commodityKey 当前商品的key
     * @return 用户当前持有的MOD商品集合
     */
    @Override
    public List<HoldUserVo> getUserHoldCommodityList(String steamId, String userQq, String commodityKey) {
        if (null == steamId || "".equals(steamId) || null == userQq || "".equals(userQq)) {
            throw new BaseException(BaseExceptionEnum.LOGIN_EXPIRE);
        }

        return userMapper.getUserHoldCommodityList(steamId, userQq, commodityKey);
    }

    /**
     * 插入用户实现方法
     *
     * @param user 用户实体类
     * @return 是否成功插入用户
     */
    @Override
    public int addUser(User user) {
        if (null != user) {
            throw new BaseException(BaseExceptionEnum.FAIL);
        }
        return userMapper.insert(user);
    }

    /**
     * 更改用户信息实现方法
     *
     * @param user   用户实体类
     * @param userId 用户id
     * @return 1成功 0失败
     */
    @Override
    public int updateUser(User user, Long userId) {
        if (userId < 1 && user != null) {
            throw new BaseException(BaseExceptionEnum.FAIL);
        }
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        updateWrapper.eq("user_id", userId);
        return userMapper.update(user, updateWrapper);
    }

    /**
     * 删除用户实现方法
     *
     * @param userId 用户ID
     * @return 1成功 0失败
     */
    @Override
    public int deleteUser(Long userId) {
        if (userId < 1) {
            throw new BaseException(BaseExceptionEnum.FAIL);
        }
        QueryWrapper<User> deleteWrapper = new QueryWrapper<>();
        deleteWrapper.eq("user_id", userId);
        return userMapper.delete(deleteWrapper);
    }

    /**
     * 批量删除user实现方法
     *
     * @param userIds 用户ID数组
     */
    @Override
    public void deleteUsers(Long[] userIds) {
        for (Long userId : userIds) {
            QueryWrapper<User> deleteWrapper = new QueryWrapper<>();
            deleteWrapper.eq("user_id", userId);
            userMapper.delete(deleteWrapper);
        }
    }

    /**
     * 获取全部的用户实现方法
     *
     * @return List<User>
     */
    @Override
    public List<User> users() {
        return userMapper.selectList(null);
    }

    /**
     * 获取单一用户实现方法
     *
     * @param userId 用户ID
     * @return User
     */
    @Override
    public User user(Long userId) {
        if (userId < 1) {
            throw new BaseException(BaseExceptionEnum.FAIL);
        }
        QueryWrapper<User> selectWrapper = new QueryWrapper<>();
        selectWrapper.eq("user_id", userId);
        return userMapper.selectOne(selectWrapper);
    }
}
