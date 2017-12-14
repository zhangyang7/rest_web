package com.pbody.rest_web.util.helper;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
     * @author Pbody
     * @create 2017-12-07 16:04
     * @description： FileUtil.java
     */
    public class FileUtil {

        private static Logger logger = LoggerFactory.getLogger(FileUtil.class);



        /**
         * 加载 properties 文件
     * 
     * @param propPath
     * @return
     */
    public static Properties loadPropFile(String propPath) {
        Properties prop = new Properties();
        InputStream is = null;
        try {
            String suffix = ".properties";
            if (propPath.lastIndexOf(suffix) == -1) {
                propPath += suffix;
            }
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(propPath);
            if (is != null) {
                prop.load(is);
            }
        } catch (Exception e) {
            logger.error("加载 properties 文件出错！", e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                logger.error("加载 properties 文件出错！", e);
            }
        }
        return prop;
    }


    /**
     * 校验文的合法性
     * @param filePath
     * @return
     * @throws Exception
     */
    public static boolean fileValidate(String filePath) throws Exception {

        if (StringUtils.isNotEmpty(filePath)) {
            File file = new File(filePath);
            return file.exists();
        }
        return false;
    }

    /**
     * 读取二进制数据从文件
     * @param filePath
     * @return
     * @throws Exception
     */
    public static byte[] getByteFromFile(String filePath) throws Exception {

        if (fileValidate(filePath)) {

            File file = new File(filePath);
            byte b[] = new byte[(int) file.length()];
            InputStream is = new FileInputStream(file);
            BufferedInputStream bi = new BufferedInputStream(is);
            bi.read(b);
            bi.close();
            is.close();
            return b;

        } else {
            logger.info("文件不合法");
        }
        return null;
    }

    /**
     * 读取文本数据从文件
     * @param filePath
     * @return
     * @throws Exception
     */
    public static String getStringOfFile(String filePath) throws Exception {

        if (fileValidate(filePath)) {

            File file = new File(filePath);
            byte b[] = new byte[(int) file.length()];
            InputStream is = new FileInputStream(file);
            BufferedInputStream bi = new BufferedInputStream(is);
            bi.read(b);
            bi.close();
            is.close();
            return new String(b);

        } else {
            logger.info("文件不合法");
        }
        return null;
    }

    /**
     * 根据文件路径生成一个新的文件
     * @param filePath
     * @return
     * @throws Exception
     */
    public static File newFile(String filePath) throws Exception {

        File file = new File(filePath);
        File dirFile = new File(file.getParent());
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;

    }

    /**
     * 获得本地不完整路径
     * @return
                * @throws Exception
                */
        public static String getLocalPath() throws Exception {

            String localFilePath = FileUtil.class.getClassLoader().getResource("/").getPath();
            localFilePath = URLDecoder.decode(
            localFilePath.substring(1, localFilePath.indexOf("WEB-INF")), "UTF-8");
        return localFilePath;
    }

    /**
     * 写文件
     * @return
     * @throws Exception
     */
    public static void writeFile(String str, String path) throws Exception {

        FileOutputStream fos = new FileOutputStream(path);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(str);
        bw.close();
    }

    /**
     * 读文件
     * @return
     * @throws Exception
     */
    public static String readFile(String path) throws Exception {

        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        br.close();
        return str;

    }
}
