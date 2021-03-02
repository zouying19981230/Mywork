package com.example.demo2.controller;

import com.example.demo2.dto.User;
import com.example.demo2.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api("用户接口")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @GetMapping("addUser")
    public String getAddUser(){
        User user=userService.addUserService("老王",19);
        log.info("UserController-getAddUser,添加用户");
        return "添加完成，添加的用户为："+user.toString();
    }

    @ResponseBody
    @GetMapping("deleteUser")
    public String getDeleteUser(){
        User user=userService.deleteUserService(1);
        log.info("UserController-getAddUser,删除用户");
        return "删除完成,删除的用户为："+user.toString();
    }

    @ResponseBody
    @GetMapping("findUser")
    public String findeUserById(){
        User user=userService.findUserService(1);
        log.info("UserController-findeUserById,通过ID查询用户");
        return "查询到的用户为："+user.toString();
    }

    @ResponseBody
    @GetMapping("updateUser")
    public String updateUser(){
        User user=userService.findUserService(1);
        log.info("UserController-updateUser,通过ID修改用户");
        return "修改后的用户为："+user.toString();
    }
}
