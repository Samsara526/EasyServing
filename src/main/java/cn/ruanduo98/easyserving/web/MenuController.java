package cn.ruanduo98.easyserving.web;

import cn.ruanduo98.easyserving.dao.TypeRepository;
import cn.ruanduo98.easyserving.po.Product;
import cn.ruanduo98.easyserving.po.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final TypeRepository typeRepository;

    @Autowired
    public MenuController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @RequestMapping
    public String menuPage(Model model, @RequestParam(defaultValue = "1") Integer id) {
        List<Type> types = typeRepository.findAll();
        List<Product> products = types.get(id - 1).getProducts();
        model.addAttribute("types", types);
        model.addAttribute("index", id);
        model.addAttribute("products", products);
        return "menu/menu";
    }

}
