package com.xxxx.cinema_try2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("t_poster")
@Data
public class Poster {
    @TableId(type = IdType.INPUT)
    String id;
    String title;
    String url;
    boolean status;
    Date createAt;
}
