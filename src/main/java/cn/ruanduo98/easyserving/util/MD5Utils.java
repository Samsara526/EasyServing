package cn.ruanduo98.easyserving.util;

import org.springframework.util.DigestUtils;

public class MD5Utils {

    public static String encodeByMd5(String password) {
        final String salt = "EasyServing V587";
        String saltPassword = salt + "+" + password;
        return DigestUtils.md5DigestAsHex(saltPassword.getBytes());
    }

}
