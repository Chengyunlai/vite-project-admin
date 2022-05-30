package top.chengyunlai.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecryptTest {

    @Test
    public void decrypt() {
        RSA rsa = new RSA();
        String privateKeyBase64 = rsa.getPrivateKeyBase64();
        System.out.println("私钥:" + privateKeyBase64);
        String publicKeyBase64 = rsa.getPublicKeyBase64();
        System.out.println("公钥:" + publicKeyBase64);
        byte[] encrypt = rsa.encrypt(StrUtil.bytes("root"), KeyType.PublicKey);
        String encode = Base64.encode(encrypt);
        System.out.println("使用公钥加密后:" + StrUtil.str(encode, CharsetUtil.CHARSET_UTF_8));
        byte[] decode = Base64.decode(encode);
        byte[] decrypt = rsa.decrypt(decode, KeyType.PrivateKey);
        System.out.println("使用私钥解密后:" + StrUtil.str(decrypt,CharsetUtil.CHARSET_UTF_8));
    }
}