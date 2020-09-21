package com.licw.springbootstudentmanage.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultBean {
    //状态码
    private Integer code;
    //提示信息
    private String message;
    //返回值
    private List data;

    private ResultBean() {
    }

    private ResultBean(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public static ResultBean error(int code, String message) {
        return new ResultBean(code,message);
    }

    public static ResultBean success(){
        return new ResultBean(0,"success");
    }

    public static ResultBean success(List data){
        ResultBean resultBean = ResultBean.success();
        resultBean.setData(data);
        return resultBean;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
