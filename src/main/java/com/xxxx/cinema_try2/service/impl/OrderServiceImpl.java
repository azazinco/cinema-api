package com.xxxx.cinema_try2.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.controller.dto.OrderDTO;
import com.xxxx.cinema_try2.entity.Arrangement;
import com.xxxx.cinema_try2.entity.Cart;
import com.xxxx.cinema_try2.entity.Order;
import com.xxxx.cinema_try2.entity.User;
import com.xxxx.cinema_try2.mapper.ArrangementMapper;
import com.xxxx.cinema_try2.mapper.FilmMapper;
import com.xxxx.cinema_try2.mapper.OrderMapper;
import com.xxxx.cinema_try2.mapper.UserMapper;
import com.xxxx.cinema_try2.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Resource
    UserMapper userMapper;
    @Resource
    FilmMapper filmMapper;
    @Resource
    ArrangementMapper arrangementMapper;
    @Override
    public Result saveOrder(List<Cart> cartList) {
        for (Cart x : cartList) {
            Order order = new Order();
            BeanUtil.copyProperties(x, order, true);
            order.setId(IdUtil.fastSimpleUUID());
            order.setCreateAt(new Date());
            save(order);
        }
        return Result.success();
    }

    @Override
    public Result getOrderByUid(String id) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", id);
        List<Order> orderList = list(queryWrapper);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        User user = userMapper.selectById(id);
        for (Order x : orderList) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrder(x);
            String aid = x.getAid();
            Arrangement arrangement = arrangementMapper.selectById(aid);
            orderDTO.setArrangement(arrangement);
            orderDTO.setUser(user);
//            String fid = arrangement
        }
        return Result.success(list(queryWrapper));
    }
}
