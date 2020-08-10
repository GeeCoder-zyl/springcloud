package com.zyl.springcloud.fallback;

import java.util.ArrayList;
import java.util.List;

import com.zyl.springcloud.client.UserFeignClient;
import org.springframework.stereotype.Component;

import com.zyl.springcloud.pojo.User;

import feign.hystrix.FallbackFactory;

/**
 * @ClassName: UserFeignClientFallbackFactory
 * @Description: 用户服务返回预期错误信息
 * @author: ZYL
 * @date: 2020/7/2 17:42
 */
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable cause) {

        return new UserFeignClient() {

            @Override
            public List<User> getAllUser() {
                User user = new User();
                user.setId(0).setName("后台服务器异常，查询用户失败").setAge(0).setSex("");
                List<User> userList = new ArrayList<User>();
                userList.add(user);
                return userList;
            }

            @Override
            public User getUserByName(String name) {
                User user = new User();
                user.setId(0).setName("后台服务器异常，查询用户失败").setAge(0).setSex("");
                return user;
            }

            @Override
            public String updateUser(Integer id, String name, Integer age, String sex) {
                return "后台服务器异常,更新用户失败";
            }

            @Override
            public String addUser(String name, Integer age, String sex) {
                return "后台服务器异常,新增用户失败";
            }

            @Override
            public String deleteUser(Integer id) {
                return "后台服务器异常,删除用户失败";
            }
        };
    }
}
