package com.springbootdemo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.Reflection;

public class Log4jUtils {

    private static Logger logger = null;

    public static org.slf4j.Logger getLogger() {
        if (null == logger) {
            //Java8 废弃了Reflection.getCallerClass()
            logger = LoggerFactory.getLogger(Reflection.getCallerClass(2).getName());
            logger.debug("调用者类名" + Reflection.getCallerClass(2).getName());
        }
        return logger;
    }

}
