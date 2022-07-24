package com.daystodie.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 查询用户已有的授权MOD
 *
 * @author leaf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoldUserVo {
    /**
     * UserID
     */
    private long userId;
    /**
     * SteamID
     */
    private String steamId;
    /**
     * UserQQ
     */
    private String userQq;
    /**
     * 用户当前权限
     */
    private String authorityName;
    /**
     * CommodityID
     */
    private long commodityId;
    /**
     * 当前Mod的名称
     */
    private String commodityName;
    /**
     * 当前MOD的代码
     */
    private String commodityCode;
    /**
     * 当前MOD的版本
     */
    private String commodityVersion;
    /**
     * 授权MOD的时间
     */
    private long holdCommodityTime;
}
