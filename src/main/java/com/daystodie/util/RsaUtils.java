package com.daystodie.util;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Rsa加密工具类
 *
 * @author leaf
 */
public class RsaUtils {

    public static String RSA_ALGORITHM = "RSA";

    /**
     * 密钥长度，DSA算法的默认密钥长度是1024
     * 密钥长度必须是64的倍数，在512到65536位之间
     */
    private static final int KEY_SIZE = 1024;
    final static Base64.Encoder ENCODER = Base64.getEncoder();


    public static void main(String[] args) throws Exception {
        String password = "都叫我iao叫哦大王打我打";
        KeyStore keys = createKeys();
        byte[] publicKey = getPublicKey(keys);
        byte[] privateKey = getPrivateKey(keys);


        System.out.println("publicKey:" + ENCODER.encodeToString(publicKey));
        System.out.println("privateKey:" + ENCODER.encodeToString(privateKey));

        byte[] encryptByPublicKey = encryptByPublicKey(password.getBytes(), publicKey);
        System.out.println("encryptByPublicKey:" + ENCODER.encodeToString(encryptByPublicKey));

        byte[] decryptByPrivateKey = decryptByPrivateKey(encryptByPublicKey, privateKey);
        System.out.println("decryptByPrivateKey:" + new String(decryptByPrivateKey, StandardCharsets.UTF_8));
    }

    /**
     * 生成密钥对
     *
     * @return 密钥对对象
     */
    public static KeyStore createKeys() throws NoSuchAlgorithmException {
        //KeyPairGenerator用于生成公钥和私钥对。密钥对生成器是使用 getInstance 工厂方法
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        return new KeyStore(publicKey, privateKey);
    }

    /**
     * 获取私钥
     */
    private static byte[] getPrivateKey(KeyStore keyStore) {
        return ((RSAPrivateKey) keyStore.privateKey).getEncoded();
    }

    /**
     * 获取公钥
     */
    private static byte[] getPublicKey(KeyStore keyStore) {
        return ((RSAPublicKey) keyStore.publicKey).getEncoded();
    }

    /**
     * 私钥加密
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPrivateKey(byte[] data, byte[] key) throws Exception {

        //取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        //数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥加密
     */
    private static byte[] encryptByPublicKey(byte[] data, byte[] key) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        //初始化公钥,根据给定的编码密钥创建一个新的 X509EncodedKeySpec。
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        //数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPrivateKey(byte[] data, byte[] key) throws Exception {
        //取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        //数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥解密
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密数据
     */
    public static byte[] decryptByPublicKey(byte[] data, byte[] key) throws Exception {

        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        //初始化公钥
        //密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        //产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        //数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        return cipher.doFinal(data);
    }


    /**
     * 定义密钥类
     */
    @Data
    @AllArgsConstructor
    public static class KeyStore {
        private Object publicKey;
        private Object privateKey;
    }
}
