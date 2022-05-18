package com.xxxx.cinema_try2.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
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
