package com.example.demo2.service;

import com.example.demo2.dao.UserDao;
import com.example.demo2.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    private Logger log = LoggerFactory.getLogger(UserService.class);

    public User addUserService(String name,Integer age){
        User user=userDao.addUser(name,age);
        log.info("UserService-addUserService,用户添加完成");
        return user;
    }

    public User deleteUserService(Integer id){
        User user=userDao.deleteUser(id);
        log.info("UserService-deleteUserService,删除用户完成");
        return user;
    }

    public User findUserService(Integer id){
        User user=userDao.findUser(id);
        log.info("UserService-findUserService,查询用户完成");
        return user;
    }

    public User updateUserService(Integer id,String name){
        User user=userDao.updateUser(id,name);
        log.info("UserService-updateUserService,修改用户完成");
        return user;
    }
}
