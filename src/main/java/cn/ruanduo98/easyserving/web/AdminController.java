package cn.ruanduo98.easyserving.web;


import cn.ruanduo98.easyserving.dao.ProductRepository;
import cn.ruanduo98.easyserving.dao.TypeRepository;
import cn.ruanduo98.easyserving.po.Order;
import cn.ruanduo98.easyserving.po.Staff;
import cn.ruanduo98.easyserving.po.TableItem;
import cn.ruanduo98.easyserving.po.Type;
import cn.ruanduo98.easyserving.service.*;
import cn.ruanduo98.easyserving.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final TypeRepository typeRepository;
    private final TableService tableService;
    private final CartService cartService;
    private final StaffService staffService;
    private final ProductRepository productRepository;
    private final OrderService orderService;
    private final OrderProductService orderProductService;

    @Autowired
    public AdminController(TypeRepository typeRepository, TableService tableService, CartService cartService, StaffService staffService, ProductRepository productRepository, OrderService orderService, OrderProductService orderProductService) {
        this.typeRepository = typeRepository;
        this.tableService = tableService;
        this.cartService = cartService;
        this.staffService = staffService;
        this.productRepository = productRepository;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @RequestMapping()
    public String index() {
        return "/admin/login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session) {
        if (session.getAttribute("staff") != null) {
            return "redirect:/admin/table";
        }
        Staff staff = staffService.findUsernameAndPassword(username, MD5Utils.encodeByMd5(password));
        if (staff != null) {
            session.setAttribute("staff", staff);
            return "redirect:/admin/table";
        }
        return "/admin/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("staff");
        return "redirect:/admin";
    }

    @RequestMapping("/table")
    public String table(Model model, HttpSession session) {
        if (session.getAttribute("staff") == null) {
            return "redirect:/admin";
        }
        model.addAttribute("tableList", tableService.findAll());
        model.addAttribute("flag", "table");
        return "admin/tableManagement";
    }

    @PostMapping("/table/info")
    public String tableInfo(Model model, Long tableId) {
        model.addAttribute("table", tableService.getOneTableById(tableId));
        return "admin/tableFragment::info_table";
    }

    @PostMapping("/table/update")
    public String tableUpdate(Long tableId, Byte tableSize) {
        TableItem tableItem = tableService.getOneTableById(tableId);
        tableItem.setSize(tableSize);
        tableService.save(tableItem);
        return "redirect:/admin/table";
    }

    @PostMapping("/table/save")
    public String tableSave(Byte tableSize) {
        TableItem tableItem = new TableItem();
        tableItem.setSize(tableSize);
        tableItem.setState((byte) 0);
        tableService.save(tableItem);
        return "redirect:/admin/table";
    }

    @PostMapping("/table/delete")
    public String tableDelete(Long tableId) {
        tableService.deleteById(tableId);
        return "redirect:/admin/table";
    }

    @RequestMapping("/menu")
    public String menu(Model model,HttpSession session) {
        if (session.getAttribute("staff") == null) {
            return "redirect:/admin";
        }
        model.addAttribute("flag", "menu");
        model.addAttribute("typeList", typeRepository.findAll());
        model.addAttribute("productList", productRepository.findAll());
        return "admin/menuManagement";
    }

    @PostMapping("/menu/saveType")
    public String saveType(String typeName, String typeIcon, String typeColor) {
        Type type = new Type();
        type.setName(typeName);
        type.setIcon(typeIcon);
        type.setColor(typeColor);
        typeRepository.save(type);
        return "redirect:/admin/menu";
    }

    @PostMapping("/menu/deleteType")
    public String deleteType(Long typeId) {
        typeRepository.deleteById(typeId);
        return "redirect:/admin/menu";
    }

    @PostMapping("/menu/updateType")
    public String updateType(Long typeId, String typeName, String typeIcon, String typeColor) {
        Type type = typeRepository.getOne(typeId);
        type.setName(typeName);
        type.setIcon(typeIcon);
        type.setColor(typeColor);
        typeRepository.save(type);
        return "redirect:/admin";
    }

    @PostMapping("/menu/typeInfo")
    public String typeInfo(Model model, Long typeId) {
        model.addAttribute("type", typeRepository.getOne(typeId));
        return "admin/menuFragment::info_type";
    }

    @PostMapping("/menu/deleteProduct")
    public String deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return "redirect:/admin/menu";
    }

    @RequestMapping("/order")
    public String order(Model model,HttpSession session) {
        if (session.getAttribute("staff") == null) {
            return "redirect:/admin";
        }
        model.addAttribute("flag", "order");
        model.addAttribute("orderList", orderService.findAll());
        return "admin/orderManagement";
    }

    @RequestMapping("/order/list")
    public String list(Model model, Long orderId) {
        model.addAttribute("orderProducts", orderProductService.findAllOrderProductsByOrderId(orderId));
        return "admin/orderFragment::info_refresh";
    }

    @RequestMapping("/staff")
    public String staff(Model model,HttpSession session) {
        if (session.getAttribute("staff") == null) {
            return "redirect:/admin";
        }
        model.addAttribute("flag", "staff");
        model.addAttribute("staffList", staffService.findAllStaff());
        model.addAttribute("roleList", staffService.findAllRole());
        return "admin/staffManagement";
    }
}

