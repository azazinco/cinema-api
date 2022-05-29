package com.xxxx.cinema_try2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.entity.Film;
import com.xxxx.cinema_try2.mapper.FilmMapper;
import com.xxxx.cinema_try2.service.IFilmService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl extends ServiceImpl<FilmMapper, Film> implements IFilmService {
    @Override
    public List<Film> ListAllFilm(boolean status) {
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", status);
        return list(queryWrapper);
    }

    @Override
    public List<Film> ListHots(Integer limit) {
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("hot").last("limit 10");
        return list(queryWrapper);
    }

    @Override
    public List<Film> SearchFilm(String name) {
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        return list(queryWrapper);
    }

    @Override
    public Result FilmDetail(String id) {
        return Result.success(getById(id));
    }
}
