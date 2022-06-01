package com.xxxx.cinema_try2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("t_order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @TableId(type = IdType.INPUT)
    String id;
    String uid;
    String phone;
    String aid;
    String seats;
    BigDecimal price;
    Integer status;
    Date createAt;
    Date payAt;
}
