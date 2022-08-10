package com.daystodie.controller;

import com.daystodie.entity.User;
import com.daystodie.service.UserService;
import com.daystodie.util.Limit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制类
 *
 * @author 123
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加新用户
     *
     * @param user 用户实体类
     * @return 1成功 0失败
     */
    @Limit(key = "addUser", permitsPerSecond = 500, timeout = 10000, msg = "当前排队人数较多，请稍后再试！")
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        log.info("调用添加用户接口");
        int i = userService.addUser(user);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }
}
