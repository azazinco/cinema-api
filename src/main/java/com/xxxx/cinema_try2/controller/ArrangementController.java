package com.xxxx.cinema_try2.controller;

import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.service.IArrangementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Controller
@RequestMapping("/arrangement")
public class ArrangementController {
    @Resource
    IArrangementService arrangementService;
    @GetMapping("/film/{fid}")
    public Result getArrangementByFid(@PathVariable String fid) {
        return arrangementService.getArrangementByFid(fid);
    }
    @GetMapping("{id}")
    public Result getArrangementById(@PathVariable String id) {
        return arrangementService.getArrangementById(id);
    }
}
