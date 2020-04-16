package cn.ruanduo98.easyserving.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "hell";
    }

    @GetMapping("/{id}")
    public String login(@PathVariable Integer id) {
        return "index";
    }
}
