package com.zqb.common;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.codec.Utf8;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright © 2012-2050,dajia Co.,Ltd. All rights reserved.
 * This program is protected by copyright laws;
 * <p>
 * Program Name: shopping-mall
 * <p>
 * Description:
 * <p>
 * Created by zengqb on 2018/10/18
 *
 * @author zengqb
 * @version 1.0
 */
public class MD5Util {

    private static final String ALGORITHM = "MD5";

    /**
     * MD5(Base64) 加密
     *
     * @param password 明文密码
     * @return  密文密码
     * @throws NoSuchAlgorithmException 异常
     */
    public static String encrypt(String password){
        //确定计算方法
        try {
            MessageDigest md5 = MessageDigest.getInstance(ALGORITHM);
            //加密后的字符串
            return Utf8.decode(Base64.encode(md5.digest(Utf8.encode(password))));
        } catch(NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm [" + ALGORITHM + "]");
        }
    }
}
