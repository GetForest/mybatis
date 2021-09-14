package com.zhangfei.utils;

import java.util.UUID;

/**
 * @author MagiskBoy
 */
public class IDUtil {



    public static String genId() {
//        return UUID.randomUUID().toString().replaceAll("-","");



        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
