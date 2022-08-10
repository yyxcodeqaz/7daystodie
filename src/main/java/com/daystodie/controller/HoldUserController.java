package com.daystodie.controller;

import com.daystodie.entity.User;
import com.daystodie.entity.vo.HoldUserVo;
import com.daystodie.service.impl.UserServiceImpl;
import com.daystodie.util.Limit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取当用户所持有的商品mod的控制类
 *
 * @author leaf
 */
@RestController
@Slf4j
public class HoldUserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 获取到用户已有的mod数据并呈现
     *
     * @param steamId id
     * @param userQq  qq
     * @param commodityKey key
     * @return HoldUserVos
     */
    @Limit(key = "getUserHoldMods", permitsPerSecond = 500, timeout = 10000, msg = "当前排队人数较多，请稍后再试！")
    @PostMapping("/getUserHoldMods")
    public List<HoldUserVo> holdUserVos(@RequestParam("id") String steamId, @RequestParam("qq") String userQq, @RequestParam("key") String commodityKey) {
        log.info("获取用户已有的Mods数据");
        return userService.getUserHoldCommodityList(steamId, userQq, commodityKey);
    }

    /**
     * 添加新用户
     *
     * @param user 用户实体类
     * @return 1成功 0失败
     */
    @Limit(key = "addUser", permitsPerSecond = 500, timeout = 10000, msg = "当前排队人数较多，请稍后再试！")
    @PostMapping("/addUser")
    public int addUser(@RequestBody User user){
        System.out.println(user.toString());
        return userService.addUser(user);
    }


}
