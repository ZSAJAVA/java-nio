package cn.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author ShouAn.Zhang
 * @date 2018/12/17 - 10:24
 */
//@RestController 相当于 @ResponeBody和@Controller 结合使用
@RestController
public class HelloController {

  // @Autowired
    private DataSource dataSource;

    //@RequestMapping("/hello")
    @GetMapping("/hello")
    public String hello(){

        return "hello springboot" +dataSource ;
    }

}
