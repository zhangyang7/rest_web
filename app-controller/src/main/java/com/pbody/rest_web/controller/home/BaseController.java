package com.pbody.rest_web.controller.home;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Pbody
 * @create 2017-12-11 15:12
 * @description： 基类Controler,封装常用的与session和response、request相关的操作
 */
public abstract class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public String toJson(Object obj) {
        if (obj == null) {
            return "{}";
        } else {
            Gson gson = new Gson();
            return gson.toJson(obj);
        }
    }

    /**
     * 传入对象文本返回json格式
     * @param obj
     * @param response
     */
    public void objReturn(Object obj, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json;charset=UTF-8");
            out = response.getWriter();
            out.print(toJson(obj));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    /**
     * 传入json文本返回json格式
     * @param json
     * @param response
     */
    public void jsonReturn(String json, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json;charset=UTF-8");
            out = response.getWriter();
            out.print(json);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    /**
     * 返回并调用jsonp函数
     * @param content
     * @param jsonpcallback
     * @param response
     */
    public void jsonpReturn(String content, String jsonpcallback, HttpServletResponse response) {
        if (StringUtils.isBlank(content)) {
            return;
        }
        if (StringUtils.isBlank(jsonpcallback)) {
            return;
        }
        PrintWriter out = null;
        String ret = null;
        try {
            response.setContentType("text/json;charset=UTF-8");
            out = response.getWriter();
            ret = jsonpcallback + "(" + content + ")";
            out.print(ret);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    public String transJson(String jsonStr) {
        if (StringUtils.isNotBlank((jsonStr))) {
            jsonStr = HtmlUtils.htmlUnescape(jsonStr);
            jsonStr = jsonStr.replaceAll("\"", "\\\\\"");
            jsonStr = jsonStr.replaceAll("\'", "\\\\\'");
        }
        return jsonStr;
    }
}