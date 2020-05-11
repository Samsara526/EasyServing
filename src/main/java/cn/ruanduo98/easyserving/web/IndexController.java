package cn.ruanduo98.easyserving.web;

import cn.ruanduo98.easyserving.service.StaffService;
import cn.ruanduo98.easyserving.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private TableService tableService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tables", tableService.findAllWithFront());
        model.addAttribute("idle", tableService.countAllByState((byte) 0));
        model.addAttribute("serving", tableService.countAllByState((byte) 1));
        model.addAttribute("order", tableService.countAllByState((byte) 2));
        return "hell";
    }

}
