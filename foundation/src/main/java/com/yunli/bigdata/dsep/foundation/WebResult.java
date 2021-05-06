package com.yunli.bigdata.dsep.foundation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "适应layui的响应结果")
public class WebResult<T> {

    @ApiModelProperty("响应码")
    private int code;

    @ApiModelProperty("响应消息")
    private String msg;

    @ApiModelProperty("响应记录总数")
    private int count;

    @ApiModelProperty("响应数据")
    private T data;

    // layui默认
    public static final int SUCCESS_CODE = 0;

    // layui默认
    public static final String SUCCESS_MSG = "";

    public static final int SUCCESS_COUNT = 0;

    public WebResult() {
    }

    public WebResult(int code, String msg, int count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return code == SUCCESS_CODE;
    }

    public static <T> WebResult<T> success(T data) {
        if (data instanceof List) {
            return new WebResult<>(SUCCESS_CODE, SUCCESS_MSG, ((List<?>) data).size(), data);
        }
        return new WebResult<>(SUCCESS_CODE, SUCCESS_MSG, SUCCESS_COUNT, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
