package com.xxxx.cinema_try2.controller;

import com.xxxx.cinema_try2.annotation.LoginToken;
import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.service.IPosterService;
import com.xxxx.cinema_try2.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("")
public class PosterController {
    @Resource
    IPosterService posterService;
//    @LoginToken
    @GetMapping("/poster")
    public Result ListAllPoster(){
//        System.out.println(posterService.ListAllPoster());
        return Result.success(posterService.ListAllPoster());
    }
}
