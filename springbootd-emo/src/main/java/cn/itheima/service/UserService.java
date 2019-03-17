package cn.itheima.service;

import cn.itheima.mapper.UserMapper;
import cn.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ShouAn.Zhang
 * @date 2018/12/17 - 17:39
 */
@Transactional
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public void addUser(){

        User user = new User();

        userMapper.insert(user);


    }


}
