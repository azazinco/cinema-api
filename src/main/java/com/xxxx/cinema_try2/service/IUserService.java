package com.xxxx.cinema_try2.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.cinema_try2.controller.dto.UserDTO;
import com.xxxx.cinema_try2.entity.User;

public interface IUserService extends IService<User> {
    UserDTO login(UserDTO userDTO);
    User getUserInfo(UserDTO userDTO);
    User register(UserDTO userDTO);
    boolean updateUser(UserDTO userDTO);
}
