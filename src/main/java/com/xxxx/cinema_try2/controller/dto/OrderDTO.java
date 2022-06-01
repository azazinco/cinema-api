package com.xxxx.cinema_try2.controller.dto;

import com.xxxx.cinema_try2.entity.Arrangement;
import com.xxxx.cinema_try2.entity.Film;
import com.xxxx.cinema_try2.entity.Order;
import com.xxxx.cinema_try2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    Order order;
    User user;
    Film film;
    Arrangement arrangement;
}
