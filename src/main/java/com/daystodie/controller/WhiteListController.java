package com.daystodie.controller;

import com.daystodie.entity.WhiteList;
import com.daystodie.service.WhiteListService;
import com.daystodie.util.Limit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 白名单控制类
 *
 * @author leaf
 */
@RestController
@Slf4j
public class WhiteListController {
    @Autowired
    private WhiteListService whiteListService;

    /**
     * 获取全部白名单
     * @return WhiteLists
     */
    @Limit(key = "getWhiteList", permitsPerSecond = 500, timeout = 10000, msg = "白名单请求次数过多，请稍后再试！")
    @GetMapping("/getWhiteList")
    public List<WhiteList> whiteLists() {
        log.info("调用白名单接口");
        return whiteListService.whiteLists();
    }
}
