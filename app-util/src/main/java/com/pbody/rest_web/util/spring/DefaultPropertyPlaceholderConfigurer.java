/**
 * zoneland.net Inc.
 * Copyright (c) 2002-2012 All Rights Reserved.
 */
package com.pbody.rest_web.util.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Pbody
 * @create 2017-12-07 16:04
 * @description： loading config.properties file
 */
public class  DefaultPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer implements InitializingBean {

    /**
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        setConfigLocation();
    }

    public synchronized  void setConfigLocation() {
        if (!setLocationWithClassPath("config.properties")) {
            throw new RuntimeException("cannot find config.properties !!");
        }

    }

    /**
     * 设置配置文件路径
     *
     * @param fileUri
     * @return
             */
    public boolean setLocationWithClassPath(String fileUri) {
        ClassPathResource classPathResource = new ClassPathResource(fileUri);
        if (classPathResource.exists()) {
            super.setLocation(classPathResource);
            if (logger.isWarnEnabled()) {
                logger.warn("load [" + fileUri + "] from classpath [" + classPathResource.getPath() + "] success.");
            }
            return true;
        }
        return false;
    }

}
