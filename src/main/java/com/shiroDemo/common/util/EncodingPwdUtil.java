package com.shiroDemo.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 散列加密算法
 */
public class EncodingPwdUtil {
    /**
     * 使用md5算法，“密码+盐（用户名）”
     * @return 加密后密码
     */
    public static String hashService(String username,String password){
        String algorithmName="md5";
        int hashIterations =2;
        SimpleHash simpleHash = new SimpleHash(algorithmName, password, username, hashIterations);
        String encodedPassword = simpleHash.toHex();
        return encodedPassword;
    }
}
