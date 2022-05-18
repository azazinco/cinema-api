package com.xxxx.cinema_try2.controller;


import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.entity.Film;
import com.xxxx.cinema_try2.service.IFilmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Resource
    IFilmService filmService;
    @GetMapping("/{status}")
    public Result NowPlayingFilm(@PathVariable boolean status) {
        return Result.success(filmService.ListAllFilm(status));
    }
    @GetMapping("/hot/{limit}")
    public Result ListHots(@PathVariable Integer limit) {
//        System.out.println(filmService.ListHots(limit));
        return Result.success(filmService.ListHots(limit));
    }
    @GetMapping("/name/{name}")
    public Result SearchFilm(@PathVariable String name) {
        return Result.success(filmService.SearchFilm(name));
    }
//    @GetMapping("hot/{limit}")
//    public
}