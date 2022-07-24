package com.daystodie.service;

import com.daystodie.entity.WhiteList;

import java.util.List;

/**
 * 白名单Service层
 *
 * @author leaf
 */
public interface WhiteListService {
    /**
     * 获取全部白名单
     *
     * @return WhiteList
     */
    List<WhiteList> whiteLists();
}
