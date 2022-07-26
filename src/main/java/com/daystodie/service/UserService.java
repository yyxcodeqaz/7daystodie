package com.daystodie.service;

import com.daystodie.entity.vo.HoldUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户服务层接口
 * @author leaf
 */
public interface UserService {
    /**
     * 获取当前用户所持有的所有MOD商品的服务层
     *
     * @param steamId 当前用户的steamId
     * @param userQq 当前用户的qq
     * @return 用户当前持有的MOD商品集合
     */
    List<HoldUserVo> getUserHoldCommodityList(String steamId,String userQq);
}
