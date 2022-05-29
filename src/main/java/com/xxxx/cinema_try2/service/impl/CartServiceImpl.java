package com.xxxx.cinema_try2.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.controller.dto.CartDTO;
import com.xxxx.cinema_try2.entity.Arrangement;
import com.xxxx.cinema_try2.entity.Cart;
import com.xxxx.cinema_try2.entity.Film;
import com.xxxx.cinema_try2.mapper.ArrangementMapper;
import com.xxxx.cinema_try2.mapper.CartMapper;
import com.xxxx.cinema_try2.mapper.FilmMapper;
import com.xxxx.cinema_try2.service.ICartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {
    @Resource
    ArrangementMapper arrangementMapper;
    @Resource
    FilmMapper filmMapper;

    @Override
    public Result getCartByUid(String uid) {
        List<CartDTO> cartDTOList = new ArrayList<>();
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        System.out.println(list(queryWrapper));
        List<Cart> cartList = list(queryWrapper);
        for (Cart x : cartList) {
            CartDTO cartDTO = new CartDTO();
            String aid = x.getAid();
            Arrangement arrangement = new Arrangement();
            arrangement = arrangementMapper.selectById(aid);
            cartDTO.setArrangement(arrangement);
            String fid = arrangement.getFid();
            Film film = new Film();
            film = filmMapper.selectById(fid);
            cartDTO.setFilm(film);
            cartDTO.setCart(x);
            cartDTOList.add(cartDTO);
        }
        return Result.success(cartDTOList);
    }

    @Override
    public Result joinCart(Cart cart) {
        cart.setId(IdUtil.fastSimpleUUID());
        save(cart);
        return Result.success();
    }
}
