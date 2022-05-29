package com.xxxx.cinema_try2.service.impl;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.cinema_try2.common.Result;
import com.xxxx.cinema_try2.entity.Film;
import com.xxxx.cinema_try2.entity.FilmEvaluate;
import com.xxxx.cinema_try2.entity.User;
import com.xxxx.cinema_try2.mapper.FeMapper;
import com.xxxx.cinema_try2.mapper.UserMapper;
import com.xxxx.cinema_try2.service.IFeService;
import com.xxxx.cinema_try2.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeServiceImpl extends ServiceImpl<FeMapper, FilmEvaluate> implements IFeService {
    @Resource
    UserMapper userMapper;

    @Override
    public Result getFilmEvaluate(String fid) {
        //根据fid查询FilmEvaluate对象
        FilmEvaluate filmEvaluate;
        QueryWrapper<FilmEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("fid", fid);
        List<FilmEvaluate> filmEvaluateList = list(queryWrapper);
//        List<User> userList = new ArrayList<>();
        List<JSONObject> jsonList = new ArrayList<>();
        User user;
        String id;
        Integer i = 0;
        for (FilmEvaluate x :filmEvaluateList) {
            JSONObject jsonObject = new JSONObject();
            user = userMapper.selectById(x.getUid());
            id = x.getId();
            jsonObject.put("id", id);
            jsonObject.put("filmEvaluate", x);
            jsonObject.put("user", user);
            jsonList.add(jsonObject);
//            System.out.println(jsonList);
        }
        return Result.success(jsonList);
    }
}
