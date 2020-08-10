package com.zyl.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ConfigController
 * @description: 描述
 * @author: ZYL
 * @date: 2020/7/7 15:50
 */
@RestController
public class ConfigController {

    @Value("${content}")//content是git文件中的key
    String content;

    @GetMapping("/config")
    public String config() {
        return "content: " + content;
    }
}
