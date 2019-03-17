package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ShouAn.Zhang
 * @date 2018/12/19 - 8:55
 */
@SpringBootApplication
@MapperScan("com.itheima.mapper")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);


    }
}
