package com.xxxx.cinema_try2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.cinema_try2.entity.Poster;

import java.util.List;

public interface IPosterService extends IService<Poster> {
    List<Poster> ListAllPoster();
}
