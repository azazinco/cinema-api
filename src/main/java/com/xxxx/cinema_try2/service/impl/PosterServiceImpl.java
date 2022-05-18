package com.xxxx.cinema_try2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.cinema_try2.entity.Poster;
import com.xxxx.cinema_try2.entity.User;
import com.xxxx.cinema_try2.mapper.PosterMapper;
import com.xxxx.cinema_try2.service.IPosterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PosterServiceImpl extends ServiceImpl<PosterMapper, Poster> implements IPosterService {

    @Override
    public List<Poster> ListAllPoster() {
        return list();
    }
}
