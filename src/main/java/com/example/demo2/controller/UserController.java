package com.example.demo2.controller;

import com.example.demo2.dto.User;
import com.example.demo2.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("用户接口")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("add.action")
    public String add(@PathVariable String name, @PathVariable Integer age){
        User user=userService.addUserService(name,age);
        log.info("UserController-getAddUser,添加用户");
        return "添加完成，添加的用户为："+user.toString();
    }

    @ResponseBody
    @RequestMapping("delete/{id}")
    public String getDeleteUser(@PathVariable Integer id){
        User user=userService.deleteUserService(id);
        log.info("UserController-getAddUser,删除用户");
        return "删除完成,删除的用户为："+user.toString();
    }

    @ResponseBody
    @RequestMapping("select")
    public String findeUserById(@PathVariable Integer id){
        User user=userService.findUserService(id);
        log.info("UserController-findeUserById,通过ID查询用户");
        return "查询到的用户为："+user.toString();
    }

    @ResponseBody
    @RequestMapping("/update/{id}/{name}")
    public String updateUser(@PathVariable Integer id, @PathVariable String name){
        User user=userService.updateUserService(id,name);
        log.info("UserController-updateUser,通过ID修改用户");
        return "修改后的用户为："+user.toString();
    }

    @ResponseBody
    @RequestMapping("/all")
    public List<User> all(){
        List<User> users=userService.findAllUserService();
        log.info("UserController-all,查询所有用户");
        return users;
    }
}
