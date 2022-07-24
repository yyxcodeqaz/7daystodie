package com.daystodie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daystodie.entity.User;
import com.daystodie.entity.vo.HoldUserVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User接口
 * @author 123
 */
@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 从数据库获取当前用户所持有的所有MOD商品
     *
     * @param steamId 当前用户的steamId
     * @return 用户当前持有的MOD商品集合
     */
    @Select("""
            SELECT
            	`user`.user_id,\s
            	`user`.steam_id,\s
            	`user`.user_qq,\s
            	authority.authority_name,\s
            	hold_user.commodity_id,\s
            	commodity.commodity_name,\s
            	commodity.commodity_code,\s
            	commodity.commodity_version,\s
            	hold_user.hold_commodity_time
            FROM
            	`user`
            	INNER JOIN
            	hold_user
            	ON\s
            		`user`.user_id = hold_user.user_id
            	INNER JOIN
            	commodity
            	ON\s
            		hold_user.commodity_id = commodity.commodity_id
            	INNER JOIN
            	authority
            	ON\s
            		`user`.authority_id = authority.authority_id
            		WHERE steam_id=#{steamId} and user_qq=#{userQq}""")

    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "steam_id", property = "steamId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_qq", property = "userQq", jdbcType = JdbcType.VARCHAR),
            @Result(column = "authority_name", property = "authorityName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "commodity_id", property = "commodityId", jdbcType = JdbcType.INTEGER),
            @Result(column = "commodity_name", property = "commodityName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "commodity_code", property = "commodityCode", jdbcType = JdbcType.LONGVARCHAR),
            @Result(column = "commodity_version", property = "commodityVersion", jdbcType = JdbcType.VARCHAR),
            @Result(column = "hold_commodity_time", property = "holdCommodityTime", jdbcType = JdbcType.INTEGER)
    })
    List<HoldUserVo> getUserHoldCommodityList(@Param("steamId") String steamId,@Param("userQq") String userQq);
}
