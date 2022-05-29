package com.xxxx.cinema_try2.service;

import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.entity.Cart;

public interface ICartService {
    Result getCartByUid(String uid);

    Result joinCart(Cart cart);
}
