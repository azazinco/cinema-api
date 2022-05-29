package com.xxxx.cinema_try2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

@TableName("t_arrangement")
@Data
public class Arrangement {
    @TableId(type = IdType.INPUT)
    String id;
    String fid;
    String name;
    int seatNumber;
    int boxOffice;
    BigDecimal price;
    String type;
    String date;
    String startTime;
    String endTime;
    String founder;
    String createAt;
}
