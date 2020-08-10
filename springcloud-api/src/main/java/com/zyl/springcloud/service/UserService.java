package com.zyl.springcloud.service;

import com.zyl.springcloud.pojo.User;

import java.util.List;

/**
 * @className: UserService
 * @description: 描述
 * @author: ZYL
 * @date: 2020/7/3 14:03
 */
public interface UserService {

    //获取所有用户的信息
    List<User> getAllUser();

    //根据用户名获取用户信息
    User getUserByName(String name);

    //新增用户
    int addUser(User user);

    //删除用户
    int deleteUser(Integer id);

    //修改用户信息
    int updateUser(User user);
}
