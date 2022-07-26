package com.daystodie.service.impl;

import com.daystodie.entity.vo.HoldUserVo;
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

    @Override
    public List<HoldUserVo> getUserHoldCommodityList(String steamId, String userQq) {
        return userMapper.getUserHoldCommodityList(steamId, userQq);
    }
}
