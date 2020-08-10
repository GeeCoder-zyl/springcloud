package com.zyl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zyl.springcloud.client.UserFeignClient;
import com.zyl.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className: UserController
 * @description: 服务消费者控制器
 * @author: ZYL
 * @date: 2020/7/3 15:43
 */
@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    //查询所有用户的信息
    @GetMapping("/getAllUser")
    @HystrixCommand(fallbackMethod="getAllUser")
    public List<User> getAllUser() {
        return userFeignClient.getAllUser();
    }

    //根据用户名获取用户信息
    @GetMapping("/getUserByName/{name}")
    @HystrixCommand(fallbackMethod="getUserByName")
    public User getUserByName(@PathVariable String name) {
        return userFeignClient.getUserByName(name);
    }

    //新增用户
    @PostMapping("/addUser/{name}/{age}/{sex}")
    @HystrixCommand(fallbackMethod="addUser")
    public String addUser(User user) {
        return userFeignClient.addUser(user.getName(), user.getAge(), user.getSex());
    }

    //删除用户
    @DeleteMapping("/deleteUser/{id}")
    @HystrixCommand(fallbackMethod="deleteUser")
    public String deleteUser(@PathVariable Integer id) {
        return userFeignClient.deleteUser(id);
    }

    //修改用户信息
    @PutMapping("/updateUser/{id}/{name}/{age}/{sex}")
    @HystrixCommand(fallbackMethod="updateUser")
    public String updateUser(User user) {
        return userFeignClient.updateUser(user.getId(), user.getName(), user.getAge(), user.getSex());
    }

}
