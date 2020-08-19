package com.leyou.test;



import com.leyou.pojo.UserInfo;

import com.leyou.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;
//import com.leyou.common.utils.RsaUtils;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

    private static final String pubKeyPath = "E:\\java\\rsa\\rsa.pub";

    private static final String priKeyPath = "E:\\java\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = com.leyou.auth.utils.JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        //String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU5NzE0Mzg3MX0.gcG9gaqahj6uW_uT6jXihsWzQa9PFAqZ9NUW7_QLWuRG9giQTplC6VKhxp7gx5oH-sbxst_Hwtli17n-0evlE_xlxkFrp-bOHVbBQLufp5HooXM4blV1GQKrU3mEpeub61-n4VWyjeVo1CDgfC131EXFzVnU5O8YcHfEwLWmxhg";

        // 解析token
        UserInfo userInfo= com.leyou.auth.utils.JwtUtils.getInfoFromToken(token,publicKey);
        //UserInfo userInfo = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + userInfo.getId());
        System.out.println("userName: " + userInfo.getUsername());
    }
}