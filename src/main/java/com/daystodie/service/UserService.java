package com.daystodie.service;

import com.daystodie.entity.User;
import com.daystodie.entity.vo.HoldUserVo;

import java.util.List;

/**
 * 用户服务层接口
 *
 * @author leaf
 */
public interface UserService {
    /**
     * 获取当前用户所持有的所有MOD商品的服务层
     *
     * @param steamId 当前用户的steamId
     * @param userQq  当前用户的qq
     * @param commodityKey  当前商品的key
     * @return 用户当前持有的MOD商品集合
     */
    List<HoldUserVo> getUserHoldCommodityList(String steamId, String userQq, String commodityKey);

    /**
     * 插入用户
     *
     * @param user 用户实体类
     * @return 是否成功插入用户
     */
    int addUser(User user);
}
