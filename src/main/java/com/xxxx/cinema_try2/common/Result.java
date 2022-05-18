package com.xxxx.cinema_try2.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code;
    private String msg;
    private Object data;
    private boolean success;
//    private String token = request.getHeader("token");

    public static Result success() {
        return new Result(Constants.CODE_200, "", null, true);
    }

    public static Result success(Object data) {
        return new Result(Constants.CODE_200, "", data, true);
    }

    public static Result error(String code, String msg) {
        return new Result(code, msg, null, false);
    }
    public static Result error() {
        return new Result(Constants.CODE_500, "系统错误", null, false);
    }
}
