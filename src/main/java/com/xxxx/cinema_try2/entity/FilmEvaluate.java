package com.xxxx.cinema_try2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@TableName("t_film_evaluate")
@Data
public class FilmEvaluate {
    @TableId(type = IdType.INPUT)
    String id;
    String fid;
    String uid;
    Integer star;
    String comment;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date createAt;
}
