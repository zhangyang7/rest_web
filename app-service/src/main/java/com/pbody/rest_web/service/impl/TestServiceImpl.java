package com.pbody.rest_web.service.impl;

import com.pbody.rest_web.service.api.TestService;
import org.springframework.stereotype.Service;

/**
 * @author Pbody
 * @create 2017-12-12 15:27
 * @description： 业务测试类
 */
@Service("testService")
public class TestServiceImpl  implements TestService{

    public String getTestStr() {
        return "This is TestStr!";
    }
}