package com.github.wxiaoqi.security.common.util;

import java.text.MessageFormat;

public class StringUtils {

    /***/
    public static String format(String template,String... args){
        return MessageFormat.format(template,args);
    }
}
