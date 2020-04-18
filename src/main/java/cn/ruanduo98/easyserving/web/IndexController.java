package cn.ruanduo98.easyserving.web;

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
        return "hell";
    }

}
