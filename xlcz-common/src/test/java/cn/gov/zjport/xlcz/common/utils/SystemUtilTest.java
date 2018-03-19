package cn.gov.zjport.xlcz.common.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

/**
 * ${desc}
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */

public class SystemUtilTest {

    public static void main(String[] args) {
        String password = "1";
        AES aes = SecureUtil.aes(password.getBytes());
        SecureUtil.des();
        String md5_pwd = SecureUtil.md5(password);
        System.out.println(md5_pwd);
    }
}
