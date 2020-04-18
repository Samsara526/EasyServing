package cn.ruanduo98.easyserving.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class StaffServiceImplTest {
    @Autowired
    private StaffService staffService;

    @Test
    void checkAdminUser() {
        System.out.println(staffService.checkAdminUser("阮铎", "19986201212"));
    }
}