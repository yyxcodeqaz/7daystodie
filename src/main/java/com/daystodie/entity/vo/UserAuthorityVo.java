package com.daystodie.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户权限Vo实体类
 *
 * @author leaf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAuthorityVo {
    /**
     * UserId
     */
    private long userId;
    /**
     * SteamId
     */
    private String steamId;
    /**
     * UserQq
     */
    private String userQq;
    /**
     * 权限名称
     */
    private String authorityName;

}
