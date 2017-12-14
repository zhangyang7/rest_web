package com.pbody.rest_web.test;

import com.pbody.rest_web.util.jetty.JettyServer;

/**
 * @author Pbody
 * @create 2017-12-07 16:04
 * @description： test environment app start entry
 */
public class JettyServerStart {

    public static void main(String[] args) throws Exception{
        JettyServer jetty = new JettyServer();
        jetty.setJettyPort(8080);
        jetty.start();
    }
}