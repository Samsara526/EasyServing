package cn.ruanduo98.easyserving.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MD5UtilsTest {

    @Test
    void encodeByMd5() {
        System.out.println(MD5Utils.encodeByMd5("19986201212"));
    }
}