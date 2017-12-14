/**
 * zoneland.net Inc.
 * Copyright (c) 2002-2012 All Rights Reserved.
 */
package com.pbody.rest_web.util.jetty;
import java.io.File;
import java.io.IOException;

import com.pbody.rest_web.util.helper.ConfigHelper;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.security.HashUserRealm;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * @author Pbody
 * @create 2017-12-07 16:04
 * @description： JettyServer Environment
 */
public class JettyServer {

    public static final int defaultJettyPort = 8080;

    private int             jettyPort        = defaultJettyPort;

    public void start() throws Exception {
        Server server = new Server(jettyPort);
        server.setHandler(createWebapp());
        server.start();
        server.join();
    }

    protected WebAppContext createWebapp() {
        WebAppContext webapp = new WebAppContext();
        webapp.setDescriptor(getWebDescriptor());
        webapp.setResourceBase(getAppRoot() + "/res-static");
        webapp.setContextPath("");
        HashUserRealm myrealm = null;
        try {
            myrealm = new HashUserRealm("MyRealm", getRealm());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (myrealm != null) {
            webapp.getSecurityHandler().setUserRealm(myrealm);
        }
        //  webapp.setParentLoaderPriority(true);
        return webapp;
    }

    /**
     * Setter method for property <tt>jettyPort</tt>.
     * 
     * @param jettyPort
     *        value to be assigned to property jettyPort
     */
    public void setJettyPort(int jettyPort) {
        this.jettyPort = jettyPort;
    }

    private String getWebDescriptor() {
        return getAppRoot() + File.separatorChar + "res-config" + File.separatorChar + "resources"
                + File.separatorChar + "web.xml";
    }

    private String getRealm() {
        return getAppRoot() + File.separatorChar + "res-config" + File.separatorChar + "resources"
               + File.separatorChar + "realm.properties";
    }

    protected String getAppName() {
        return ConfigHelper.getInstance().getStringProperty("app_name");
    }

    protected String getAppRoot() {
        return ConfigHelper.getInstance().getStringProperty("app_root");
    }

}
