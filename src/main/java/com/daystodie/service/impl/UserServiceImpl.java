package com.daystodie.service.impl;

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
     * 获取当前用户已有的mod的接口
     *
     * @param steamId 当前用户的steamId
     * @param userQq  当前用户的qq
     * @return 用户当前持有的MOD商品集合
     */
    @Override
    public List<HoldUserVo> getUserHoldCommodityList(String steamId, String userQq) {
        if (null == steamId || "".equals(steamId)|| null == userQq|| "".equals(userQq)) {
            throw new BaseException(BaseExceptionEnum.LOGIN_EXPIRE);
        }
        return userMapper.getUserHoldCommodityList(steamId, userQq);
    }
}
