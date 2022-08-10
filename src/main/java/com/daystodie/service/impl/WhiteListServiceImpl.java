package com.daystodie.service.impl;

import com.daystodie.entity.WhiteList;
import com.daystodie.mapper.WhiteListMapper;
import com.daystodie.service.WhiteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 白名单Service实现类
 *
 * @author leaf
 */
@Service
public class WhiteListServiceImpl implements WhiteListService {
    @Autowired
    WhiteListMapper whiteListMapper;

    /**
     * 获取全部白名单实现方法
     *
     * @return WhiteList
     */
    @Override
    public List<WhiteList> whiteLists() {
        return whiteListMapper.selectList(null);
    }
}
