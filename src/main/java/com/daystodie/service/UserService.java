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
     * @param steamId      当前用户的steamId
     * @param userQq       当前用户的qq
     * @param commodityKey 当前商品的key
     * @return 用户当前持有的MOD商品集合
     */
    List<HoldUserVo> getUserHoldCommodityList(String steamId, String userQq, String commodityKey);

    /**
     * 插入用户
     *
     * @param user 用户实体类
     * @return 1成功 0失败
     */
    int addUser(User user);

    /**
     * 更改用户信息
     *
     * @param user   用户实体类
     * @param userId 用户id
     * @return 1成功 0失败
     */
    int updateUser(User user, Long userId);

    /**
     * 删除用户
     *
     * @param userId 用户ID
     * @return 1成功 0失败
     */
    int deleteUser(Long userId);

    /**
     * 获取全部的用户
     *
     * @return List<User>
     */
    List<User> users();

    /**
     * 获取单一用户
     *
     * @param userId 用户ID
     * @return User
     */
    User user(Long userId);
}
