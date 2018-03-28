package com.cqupt.project.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author weigs
 * @date 2018/3/28 0028
 */
public class PropertiesUtil {
    private static final Logger log =
            LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties properties;

    static {
        properties = new Properties();
        String filename = "pw.properties";
        try {
            properties.load(new InputStreamReader(PropertiesUtil.class
                    .getClassLoader().getResourceAsStream(filename), "UTF-8"));
        } catch (Exception e) {
            log.error("配置文件读取错误", e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return value.trim();

    }

    public static String getProperty(String key, String defaultValue) {
        String value = properties.getProperty(key);
        if (StringUtils.isBlank(value)) {
            value = defaultValue;
        }
        return value.trim();
    }
}
