package com.xxxx.cinema_try2.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.xxxx.cinema_try2.common.Constants;
import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.controller.dto.UserDTO;
import com.xxxx.cinema_try2.entity.User;
import com.xxxx.cinema_try2.service.IUserService;
import com.xxxx.cinema_try2.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class UserController {
    @Resource
    private IUserService userService;
    @PostMapping("/user/login")
    public Result login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(Constants.CODE_400, "参数错误");
        }
        UserDTO dto = userService.login(userDTO);
        User user = userService.getUserInfo(userDTO);
        JSONObject jsonObject=new JSONObject();
        String token = TokenUtils.getToken(user.getId().toString(), user.getPassword());
        jsonObject.put("token", token);
        jsonObject.put("user", user);
        return Result.success(jsonObject);
    }
    @PostMapping("/user/register")
    public Result register(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(Constants.CODE_400, "参数错误");
        }
        userService.register(userDTO);
        return Result.success();
    }
    @PutMapping("/me/user")
    public Result updateUser(@RequestBody User user) {
        return Result.success(userService.updateUser(user));
    }
//    @GetMapping("/me/user")
//    public Result getUserInfo(@RequestBody User user) {
//        return Result.success(userService.updateUser(user));
//    }
}
