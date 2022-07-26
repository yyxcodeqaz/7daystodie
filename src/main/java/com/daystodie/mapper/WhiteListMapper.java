package com.daystodie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daystodie.entity.WhiteList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 白名单列表dao接口
 * @author leaf
 */
@Mapper
@Component
public interface WhiteListMapper extends BaseMapper<WhiteList> {
}
