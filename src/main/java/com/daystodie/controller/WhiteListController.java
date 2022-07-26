package com.daystodie.controller;

import com.daystodie.entity.WhiteList;
import com.daystodie.entity.vo.ResultVo;
import com.daystodie.service.WhiteListService;
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

    @GetMapping("/getWhiteList")
    public ResultVo<List<WhiteList>> whiteLists() {
        log.info("调用白名单接口");
        return new ResultVo<>(whiteListService.whiteLists());
    }
}
