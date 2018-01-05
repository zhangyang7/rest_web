package com.pbody.rest_web.pojo;

/**
 * @author Pbody
 * @create 2017-12-11 15:04
 * @description： 响应状态码
 */
public enum RespCode {

    Accepted(202,"已接受处理请求但尚未完成（异步处理）!"),
    Invalid_Request(400,"用户发出的请求有错误!"),
    Unauthorized(400,"用户没有权限（令牌、用户名、密码错误）!"),
    Forbidden(403,"当前访问资源是被禁止的，无权限!"),
    Not_Found(404,"用户发出的请求针对的是不存在的记录!"),
    Not_Acceptable(406,"用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）!"),
    Gone(410,"用户请求的资源被永久删除，且不会再得到的!"),
    Unprocesable_entity(422,"当创建一个对象时，发生一个验证错误!"),
    Internal_Server_Error(500,"服务器发生错误!"),
    Service_Unavailable(503,"服务当前无法处理请求!");

    private int code;
    private String msg;
    private RespCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
