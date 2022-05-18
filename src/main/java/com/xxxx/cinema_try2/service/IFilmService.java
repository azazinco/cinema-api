package com.xxxx.cinema_try2.service;

import com.xxxx.cinema_try2.entity.Film;

import java.util.List;

public interface IFilmService {
    List<Film> ListAllFilm(boolean status);
    List<Film> ListHots(Integer limit);
    List<Film> SearchFilm(String name);
}
