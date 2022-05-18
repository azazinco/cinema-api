package com.xxxx.cinema_try2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("t_user")
@Data
public class User {
    @TableId(type = IdType.INPUT)
    private String id;
    private String username;
    private String password;
    private String avatar;
    private String nickname;
    private String email;
    private Date birthday;
    private String gender;
    private String info;
    private Date createAt;
    private Date updateAt;
}
