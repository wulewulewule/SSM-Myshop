package com.funtl.my.shop.commons.dto;

import java.io.Serializable;

/**
 * @program: my-shop
 * @description: 自定义返回结果
 * @author: wule
 * @create: 2019-08-09 14:01
 **/

public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;


    private int status;
    private String message;

    public static BaseResult success() {
        /*BaseResult baseResult =new BaseResult();
        baseResult.setStatus(200);
        baseResult.setMessage("成功");
        return baseResult;*/
        return BaseResult.createResult(STATUS_SUCCESS, "成功！");

    }

    public static BaseResult success(String message) {
        /*BaseResult baseResult =new BaseResult();
        baseResult.setStatus(200);
        baseResult.setMessage(message);
        return baseResult;*/
        return BaseResult.createResult(STATUS_SUCCESS, message);
    }


    public static BaseResult fail() {
        /*BaseResult baseResult =new BaseResult();
        baseResult.setStatus(500);
        baseResult.setMessage("失败");
        return baseResult;*/
        return BaseResult.createResult(STATUS_FAIL, "失败！！！");
    }

    public static BaseResult fail(String message) {
        return BaseResult.createResult(STATUS_FAIL, message);
    }

    public static BaseResult fail(int status, String message) {

        return BaseResult.createResult(status, message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //重构
    private static BaseResult createResult(int status, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }
}
