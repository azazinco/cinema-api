package com.xxxx.cinema_try2.service;

import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.entity.Cart;
import com.xxxx.cinema_try2.entity.Order;

import java.util.List;

public interface IOrderService {
    Result saveOrder(List<Cart> cartlist);

    Result getOrderByUid(String id);
}
