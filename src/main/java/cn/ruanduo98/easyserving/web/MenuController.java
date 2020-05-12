package cn.ruanduo98.easyserving.web;

import cn.ruanduo98.easyserving.dao.TypeRepository;
import cn.ruanduo98.easyserving.po.Product;
import cn.ruanduo98.easyserving.po.Type;
import cn.ruanduo98.easyserving.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    public MenuController(TypeRepository typeRepository, TableService tableService) {
        this.typeRepository = typeRepository;
        this.tableService = tableService;
    }

    private final TypeRepository typeRepository;
    private final TableService tableService;

    @RequestMapping
    public String menuPage(Model model, @RequestParam(defaultValue = "1") Integer id, HttpSession session) {
        if (session.getAttribute("tableId") == null) {
            model.addAttribute("tables", tableService.findAllWithFront());
            model.addAttribute("idle", tableService.countAllByState((byte) 0));
            model.addAttribute("serving", tableService.countAllByState((byte) 1));
            model.addAttribute("order", tableService.countAllByState((byte) 2));
            return "menu/table";
        }
        List<Type> types = typeRepository.findAll();
        List<Product> products = types.get(id - 1).getProducts();
        model.addAttribute("types", types);
        model.addAttribute("index", id);
        model.addAttribute("products", products);
        return "menu/menu";
    }

    //开始就餐
    @PostMapping("/startServing")
    public String startServing(Model model, Long tableId, HttpSession session) {
        if (tableId != null) {
            session.setAttribute("tableId", tableId);
            //设置开始就餐
            tableService.updateTableStatueById(tableId, (byte) 1);
            return "redirect:/menu";
        }
        model.addAttribute("tables", tableService.findAllWithFront());
        model.addAttribute("idle", tableService.countAllByState((byte) 0));
        model.addAttribute("serving", tableService.countAllByState((byte) 1));
        model.addAttribute("order", tableService.countAllByState((byte) 2));
        return "redirect:/menu";
    }

    //结束就餐
    @PostMapping("endServing")
    public String endServing(Model model, Long tableId, HttpSession session) {
        if (tableId != null) {
            //设置餐桌为空闲
            tableService.updateTableStatueById(tableId, (byte) 0);
        }
        return "redirect:/menu";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("tableId");
        return "redirect:/menu";
    }
}
