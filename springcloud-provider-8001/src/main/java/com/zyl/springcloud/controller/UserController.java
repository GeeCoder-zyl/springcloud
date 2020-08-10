package com.zyl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zyl.springcloud.pojo.User;
import com.zyl.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className: UserController
 * @description: 服务提供者控制器
 * @author: ZYL
 * @date: 2020/7/3 14:11
 */
@RestController//使用RESTful风格
public class UserController {

    @Autowired
    private UserService userService;

    //获取所有用户的信息
    @GetMapping("/getAllUser")
    @HystrixCommand(fallbackMethod = "getAllUser")
    public List<User> getAllUser() {
        List<User> userList = userService.getAllUser();
        return userList;
    }

    //根据用户名获取用户信息
    @GetMapping("/getUserByName/{name}")
    @HystrixCommand(fallbackMethod = "getUserByName")
    public User getUserByName(@PathVariable String name) {
        User user = userService.getUserByName(name);
        return user;
    }

    //新增用户
    @PostMapping("/addUser/{name}/{age}/{sex}")
    @HystrixCommand(fallbackMethod = "addUser")
    public int addUser(User user) {
        int num = userService.addUser(user);
        return num;
    }

    //删除用户
    @DeleteMapping("/deleteUser/{id}")
    @HystrixCommand(fallbackMethod = "deleteUser")
    public int deleteUser(@PathVariable Integer id) {
        int num = userService.deleteUser(id);
        return num;
    }

    //修改用户信息
    @PutMapping("/updateUser/{id}/{name}/{age}/{sex}")
    @HystrixCommand(fallbackMethod = "updateUser")
    public int updateUser(User user) {
        int num = userService.updateUser(user);
        return num;
    }

}
