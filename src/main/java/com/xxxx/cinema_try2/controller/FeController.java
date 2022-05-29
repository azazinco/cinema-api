package com.xxxx.cinema_try2.controller;

import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.entity.FilmEvaluate;
import com.xxxx.cinema_try2.service.IFeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class FeController {
    @Resource
    IFeService feService;
    @GetMapping("/fe")
    public Result getFilmEvaluate(@RequestParam String fid){
        return feService.getFilmEvaluate(fid);
    }
}
