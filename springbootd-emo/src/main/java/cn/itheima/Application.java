package cn.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author ShouAn.Zhang
 * @date 2018/12/17 - 10:17
 */
@SpringBootApplication
@MapperScan("cn.itheima.mapper")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }
}
