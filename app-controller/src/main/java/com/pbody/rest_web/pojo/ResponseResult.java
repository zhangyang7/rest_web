package com.pbody.rest_web.pojo;

/**
 * @author Pbody
 * @create 2017-12-11 15:04
 * @description：
 */
public class ResponseResult {
    private String result; // “1”成功，“0”，失败
    private String message; // result为“1”时返回“成功”；为“0”时返回“具体错误信息描述”

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseResult [result=" + result + ", message=" + message + "]";
    }
}
