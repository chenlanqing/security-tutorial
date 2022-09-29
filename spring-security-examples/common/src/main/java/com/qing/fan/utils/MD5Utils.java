package com.qing.fan.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author QingFan 2022/9/26
 * @version 1.0.0
 */
public class MD5Utils {

    public static void main(String[] args) {
        String encode = base64Decode("bk5xNTBCZVJEQTFuVG9wRnlabWZFQSUzRCUzRDozRkFid0szQXNwcm1CZlgyeXROVDRBJTNEJTNE");
        System.out.println(encode);
        System.out.println(base64Encode(encode));
    }

    /**
     * 将一个base64编码后的字符串解码
     */
    public static String base64Decode(String encode) {
        return new String(Base64.getDecoder().decode(encode), StandardCharsets.UTF_8);
    }

    /**
     * 对字符串进行Base64编码
     */
    public static String base64Encode(String code) {
        return new String(Base64.getEncoder().encode(code.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }
}
