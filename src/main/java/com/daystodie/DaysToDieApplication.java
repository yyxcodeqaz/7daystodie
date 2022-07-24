package com.daystodie;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * Springboot启动类
 * MapperScan 扫描Mapper接口
 * ComponentScan 扫描Component实体类
 * @author leaf
 */
@SpringBootApplication
public class DaysToDieApplication {
    public static void main(String[] args) {
        SpringApplication.run(DaysToDieApplication.class, args);
    }

}
