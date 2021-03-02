package com.example.demo2.dao;

import com.example.demo2.Repository.UserJpa;
import com.example.demo2.dto.User;
import com.example.demo2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    UserJpa userJpa;

    private Logger log = LoggerFactory.getLogger(UserService.class);

    public User addUser(String name,Integer age){
        User user=new User(name,age);
        userJpa.save(user);
        log.info("UserService-addUser,添加用户，用户名为：{}",user.getName(),"用户年龄为：{}",user.getAge());
        System.out.println(user.toString());
        return user;
    }

    public User deleteUser(Integer id){
        Optional<User> userOptional = userJpa.findById(id);
        User user=userOptional.get();
        userJpa.deleteById(id);
        log.info("UserService-deleteUser,删除用户，用户名为：{}",user.getName(),"用户年龄为：{}",user.getAge());
        return user;
    }

    public User updateUser(Integer id, String name){
        User user = userJpa.findById(id).get();
        user.setName(name);
        userJpa.save(user);
        log.info("UserService-updateUser,修改用户，用户名为：{}",user.getName(),"用户年龄为：{}",user.getAge());
        return user;
    }

    public User findUser(Integer id){
        Optional<User> userOptional = userJpa.findById(id);
        User user=userOptional.get();
        log.info("UserService-findUser,通过ID查询用户，用户名为：{}",user.getName(),"用户年龄为：{}",user.getAge());
        return user;
    }
}
