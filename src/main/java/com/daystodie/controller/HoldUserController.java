package com.daystodie.controller;

import com.daystodie.entity.vo.HoldUserVo;
import com.daystodie.service.impl.UserServiceImpl;
import com.daystodie.util.Limit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取当用户所持有的商品mod的控制类
 *
 * @author 123
 */
@RestController
@Slf4j
public class HoldUserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 获取到用户已有的mod数据并呈现
     * @param steamId id
     * @param userQq qq
     * @return HoldUserVos
     */
    @Limit(key = "getUserHoldMods", permitsPerSecond = 500, timeout = 10000, msg = "当前排队人数较多，请稍后再试！")
    @PostMapping("/getUserHoldMods")
    public List<HoldUserVo> holdUserVos(@RequestParam("id") String steamId,@RequestParam("qq") String userQq) {
        log.info("获取用户已有的Mods数据");
        return userService.getUserHoldCommodityList(steamId,userQq);
    }
}
