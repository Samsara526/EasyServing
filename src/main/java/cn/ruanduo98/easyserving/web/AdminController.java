package cn.ruanduo98.easyserving.web;


import cn.ruanduo98.easyserving.dao.ProductRepository;
import cn.ruanduo98.easyserving.dao.TypeRepository;
import cn.ruanduo98.easyserving.service.CartService;
import cn.ruanduo98.easyserving.service.StaffService;
import cn.ruanduo98.easyserving.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public AdminController(TypeRepository typeRepository, TableService tableService, CartService cartService, StaffService staffService, ProductRepository productRepository) {
        this.typeRepository = typeRepository;
        this.tableService = tableService;
        this.cartService = cartService;
        this.staffService = staffService;
        this.productRepository = productRepository;
    }

    private final TypeRepository typeRepository;
    private final TableService tableService;
    private final CartService cartService;
    private final StaffService staffService;
    private final ProductRepository productRepository;

    @RequestMapping("/table")
    public String table(Model model) {
        model.addAttribute("tableList", tableService.findAll());
        model.addAttribute("flag", "table");
        return "admin/tableManagement";
    }

    @RequestMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("flag", "menu");
        model.addAttribute("typeList", typeRepository.findAll());
        model.addAttribute("productList", productRepository.findAll());
        return "admin/menuManagement";
    }

    @RequestMapping("/order")
    public String order(Model model) {
        model.addAttribute("flag", "order");
        return "admin/orderManagement";
    }

    @RequestMapping("/staff")
    public String staff(Model model) {
        model.addAttribute("flag", "staff");
        model.addAttribute("staffList", staffService.findAllStaff());
        model.addAttribute("roleList", staffService.findAllRole());
        return "admin/staffManagement";
    }
}

