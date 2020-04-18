package cn.ruanduo98.easyserving.web;

import cn.ruanduo98.easyserving.po.Staff;
import cn.ruanduo98.easyserving.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    public String index() {
        Staff staff=staffService.checkAdminUser("阮铎","19986201212");
        System.out.println(staff);
        return "hell";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }
}
