package com.xxxx.cinema_try2.controller;

import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.entity.Cart;
import com.xxxx.cinema_try2.entity.Order;
import com.xxxx.cinema_try2.service.IOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    IOrderService orderService;

    @PostMapping
    public Result saveOrder(@RequestBody List<Cart> cartList) {
        return orderService.saveOrder(cartList);
    }
    @GetMapping("/user/{id}")
    public Result getOrderByUid(@PathVariable String id) {
        return orderService.getOrderByUid(id);
    }
}
