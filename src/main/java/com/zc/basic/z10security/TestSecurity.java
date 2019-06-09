package com.zc.basic.z10security;

import org.junit.Test;

public class TestSecurity
{
    private static final String filepath = "E:/test/";
    
    @Test
    public void testGen()
    {
        //生成公钥私钥,只生成一次即可
        RSAEncrypt.genKeyPair(filepath);  
    }

    public static void main(String[] args) throws Exception
    {
        //生成公钥私钥,只生成一次即可
        //RSAEncrypt.genKeyPair(filepath);  
        
        System.out.println("--------------公钥加密私钥解密过程-------------------");
        String plainText = "公钥加密私钥解密测试文本";
        //公钥加密过程  
        byte[] cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),
                plainText.getBytes());
        String miTxt = Base64.encode(cipherData);
        //私钥解密过程  
        byte[] res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),
                Base64.decode(miTxt));
        String restr = new String(res);
        System.out.println("原文：" + plainText);
        System.out.println("加密：" + miTxt);
        System.out.println("解密：" + restr);
        System.out.println();

        System.out.println("--------------私钥加密公钥解密过程-------------------");
        plainText = "私钥加密公钥解密测试文本";
        //私钥加密过程  
        cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),
                plainText.getBytes());
        miTxt = Base64.encode(cipherData);
        //公钥解密过程  
        res = RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),
                Base64.decode(miTxt));
        restr = new String(res);
        System.out.println("原文：" + plainText);
        System.out.println("加密：" + miTxt);
        System.out.println("解密：" + restr);
        System.out.println();

        System.out.println("---------------私钥签名过程------------------");
        String content = "这是用于签名的原始数据";
        String signstr = RSASignature.sign(content, RSAEncrypt.loadPrivateKeyByFile(filepath));
        System.out.println("签名原串：" + content);
        System.out.println("签名串：" + signstr);
        System.out.println();

        System.out.println("---------------公钥校验签名------------------");
        System.out.println("签名原串：" + content);
        System.out.println("签名串：" + signstr);

        System.out.println("验签结果：" + RSASignature.doCheck(content, signstr, RSAEncrypt.loadPublicKeyByFile(filepath)));
        System.out.println();

    }
}
