package com.xxxx.cinema_try2.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.cinema_try2.common.Constants;
import com.xxxx.cinema_try2.controller.dto.UserDTO;
import com.xxxx.cinema_try2.entity.User;
import com.xxxx.cinema_try2.exception.ServiceException;
import com.xxxx.cinema_try2.mapper.UserMapper;
import com.xxxx.cinema_try2.service.IUserService;
import com.xxxx.cinema_try2.utils.TokenUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserDTO login(UserDTO userDTO) {
//        System.out.println(list());
        User one = getUserInfo(userDTO);
        if (one != null) {
            BeanUtil.copyProperties(one, userDTO, true);
            //设置token
//            String token = TokenUtils.getToken(one.getId().toString(), one.getPassword());
//            userDTO.setToken(token);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public User getUserInfo(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());
        User one;
        try {
            one = getOne(queryWrapper); //从数据库查询用户信息
        } catch (Exception e) {
//            LOG.error(e);
            throw new ServiceException(Constants.CODE_600, "系统错误");
        }
        return one;
    }

    @Override
    public User register(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO, one, true);
            one.setId(IdUtil.fastSimpleUUID());one.setNickname("null");
            one.setCreateAt(new Date());
            one.setUpdateAt(new Date());
            save(one); //插入
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return null;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        return updateById(one);
    }

}