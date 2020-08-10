package com.zyl.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Description: 描述
 * @author: ZYL
 * @date: 2020/7/2 17:42
 */
@Data//开启lombok
@Accessors(chain = true)//开启级联操作，为true时setter方法返回当前对象
@ToString//生成toString()方法
@TableName(value = "tb_user")//开始mybatis-plus表映射，当表名与类名不一样时，需要配置value属性
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
