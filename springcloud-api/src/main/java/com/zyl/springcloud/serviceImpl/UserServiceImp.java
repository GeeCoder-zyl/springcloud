package com.zyl.springcloud.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyl.springcloud.mapper.UserMapper;
import com.zyl.springcloud.pojo.User;
import com.zyl.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: UserServiceImp
 * @description: 描述
 * @author: ZYL
 * @date: 2020/7/3 14:04
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired(required = false)
    public UserMapper userMapper;

    //获取所有用户的信息
    @Override
    public List<User> getAllUser() {
        List<User> userList = userMapper.selectList(null);
        return userList;
    }

    //根据用户名获取用户信息
    @Override
    public User getUserByName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    //新增用户
    @Override
    public int addUser(User user) {
        int num = userMapper.insert(user);
        return num;
    }

    //删除用户
    @Override
    public int deleteUser(Integer id) {
        int num = userMapper.deleteById(id);
        return num;
    }

    //修改用户信息
    @Override
    public int updateUser(User user) {
        int num = userMapper.updateById(user);
        return num;
    }
}
