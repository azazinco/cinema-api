package com.xxxx.cinema_try2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.controller.dto.ArrangementDTO;
import com.xxxx.cinema_try2.entity.Arrangement;
import com.xxxx.cinema_try2.entity.Film;
import com.xxxx.cinema_try2.mapper.ArrangementMapper;
import com.xxxx.cinema_try2.mapper.FilmMapper;
import com.xxxx.cinema_try2.service.IArrangementService;
import com.xxxx.cinema_try2.service.IFilmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class IArrangementImpl extends ServiceImpl<ArrangementMapper, Arrangement> implements IArrangementService {
    @Resource
    FilmMapper filmMapper;
    @Override
    public Result getArrangementByFid(String fid) {
        QueryWrapper<Arrangement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("fid", fid);
        List<Arrangement> arrangementList = list(queryWrapper);
        ArrangementDTO arrangementDTO = new ArrangementDTO();
        arrangementDTO.setArrangements(arrangementList);
        Film film = filmMapper.selectById(fid);
        arrangementDTO.setFilm(film);
        return Result.success(arrangementDTO);
    }

    @Override
    public Result getArrangementById(String id) {
        return Result.success(getById(id));
    }
}
