package com.xxxx.cinema_try2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@TableName("t_film")
@Data
public class Film {
    @TableId(type = IdType.INPUT)
    String id;
    String name;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date releaseTime;
    String type;
    boolean status;
    String region;
    Integer hot;
    String introduction;
    String cover;
    Integer duration;
    String isDelete;
}
