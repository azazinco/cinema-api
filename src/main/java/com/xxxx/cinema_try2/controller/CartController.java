package com.xxxx.cinema_try2.controller;

import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.entity.Cart;
import com.xxxx.cinema_try2.service.ICartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    ICartService cartService;
    @PostMapping
    public Result joinCart(@RequestBody Cart cart) {
        return cartService.joinCart(cart);
    }
    @GetMapping
    public Result getCartByUid(@RequestParam String uid) {
        return cartService.getCartByUid(uid);
    }
//    @DeleteMapping("/{id}")
//    public Result deleteCartById(@PathVariable String id) {
//        return null;
//    }
}
