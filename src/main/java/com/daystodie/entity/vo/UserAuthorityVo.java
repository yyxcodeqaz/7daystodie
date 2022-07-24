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
    private long userId;
    private String steamId;
    private String userQq;
    private String authorityName;

}
