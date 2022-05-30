package top.chengyunlai.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName
 * @Description
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
public class Decrypt {
    public static String decrypt(String encode) throws IOException {
        String decode = null;
        // 获取传入的密文
        decode = encode;
        // 读取秘钥文件
        FileInputStream inputStream = new FileInputStream("src/main/resources/privateKey");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = new byte[1024];
        int len = 0;
        String key = null;
        // 得到秘钥文件
        while ((len = bufferedInputStream.read(bytes))!=-1){
            key = new String(bytes, 0, len);
        }
        // 通过RSA解密，只需需要传入秘钥即可
        RSA rsa = new RSA(key, null);
        // 将密文使用Base64编码反编译
        byte[] decryptCode = Base64.decode(decode);
        // 解密
        byte[] decrypt = rsa.decrypt(decode, KeyType.PrivateKey);
        // 将解密的内容，使用字符串显示出来
        String res = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
        bufferedInputStream.close();
        inputStream.close();
        // 返回明文
        return res;
    }
}
