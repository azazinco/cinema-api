package com.xxxx.cinema_try2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@TableName("t_cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @TableId(type = IdType.INPUT)
    String id;
    String uid;
    String aid;
    int status;
    String phone;
    String seats;
    BigDecimal price;
}
