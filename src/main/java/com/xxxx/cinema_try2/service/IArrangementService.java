package com.xxxx.cinema_try2.service;

import com.xxxx.cinema_try2.common.Result;

public interface IArrangementService {
    Result getArrangementByFid(String fid);

    Result getArrangementById(String id);
}
