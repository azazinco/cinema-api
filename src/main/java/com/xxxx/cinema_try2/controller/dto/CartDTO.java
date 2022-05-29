package com.xxxx.cinema_try2.controller.dto;

import com.xxxx.cinema_try2.entity.Arrangement;
import com.xxxx.cinema_try2.entity.Cart;
import com.xxxx.cinema_try2.entity.Film;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    Film film;
    Arrangement arrangement;
    Cart cart;
}
