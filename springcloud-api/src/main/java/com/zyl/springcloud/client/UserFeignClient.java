package com.zyl.springcloud.client;

import com.zyl.springcloud.fallback.UserFeignClientFallbackFactory;
import com.zyl.springcloud.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @className: UserService
 * @description: Feign客户端
 * @author: ZYL
 * @date: 2020/7/3 15:40
 */
@FeignClient(value = "provider-user", fallbackFactory = UserFeignClientFallbackFactory.class)//指定服务提供者的服务名称和fallback类
public interface UserFeignClient {

    //查询所有用户的信息
    @GetMapping("/getAllUser")
    List<User> getAllUser();

    //根据用户名获取用户信息
    @GetMapping("/getUserByName/{name}")
    User getUserByName(@PathVariable String name);

    //新增用户
    @PostMapping("/addUser/{name}/{age}/{sex}")
    String addUser(@PathVariable String name, @PathVariable Integer age, @PathVariable String sex);

    //删除用户
    @DeleteMapping("/deleteUser/{id}")
    String deleteUser(@PathVariable Integer id);

    //修改用户信息
    @PutMapping("/updateUser/{id}/{name}/{age}/{sex}")
    String updateUser(@PathVariable Integer id, @PathVariable String name, @PathVariable Integer age, @PathVariable String sex);
}
