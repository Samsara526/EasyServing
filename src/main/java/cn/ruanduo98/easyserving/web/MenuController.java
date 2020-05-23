package cn.ruanduo98.easyserving.web;

import cn.ruanduo98.easyserving.dao.TypeRepository;
import cn.ruanduo98.easyserving.po.Cart;
import cn.ruanduo98.easyserving.po.Product;
import cn.ruanduo98.easyserving.po.Type;
import cn.ruanduo98.easyserving.service.CartService;
import cn.ruanduo98.easyserving.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    public MenuController(TypeRepository typeRepository, TableService tableService, CartService cartService) {
        this.typeRepository = typeRepository;
        this.tableService = tableService;
        this.cartService = cartService;

    }

    private final TypeRepository typeRepository;
    private final TableService tableService;
    private final CartService cartService;

    @RequestMapping
    public String menuPage(Model model, @RequestParam(defaultValue = "1") Integer id, HttpSession session) {
        Long tableId = (Long) session.getAttribute("tableId");
        if (tableId == null) {
            model.addAttribute("tables", tableService.findAllWithFront());
            model.addAttribute("idle", tableService.countAllByState((byte) 0));
            model.addAttribute("serving", tableService.countAllByState((byte) 1));
            model.addAttribute("order", tableService.countAllByState((byte) 2));
            return "menu/table";
        }
        List<Type> types = typeRepository.findAll();
        List<Product> products = types.get(id - 1).getProducts();
        //将全部类别添加到菜单页面
        model.addAttribute("types", types);
        //将类别索引添加到菜单页面
        model.addAttribute("index", id);
        //将对应产品添加到菜单页面
        model.addAttribute("products", products);
        //将已就餐时间添加到菜单页面
        model.addAttribute("servingTime", tableService.getServingTimeById((Long) session.getAttribute("tableId")));
        model.addAttribute("carts", cartService.findAllByTableIdToPage(tableId));
        return "menu/menu";
    }

    //开始就餐
    @PostMapping("/startServing")
    public String startServing(Model model, Long tableId, HttpSession session) {
        if (tableId != null) {
            session.setAttribute("tableId", tableId);
            //设置开始就餐
            if (tableService.getOneTableById(tableId).getState() != 1) {
                tableService.updateTableStatueById(tableId, (byte) 1);
                tableService.updateTableServingBeginTimeById(tableId, new Date());
            }
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
            tableService.updateTableServingBeginTimeById(tableId, null);
        }
        return "redirect:/menu";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("tableId");
        session.removeAttribute("table");
        return "redirect:/menu";
    }

    @PostMapping("/addProduct")
    public String addProduct(Long productId, HttpSession session) {
        Long tableId = (Long) session.getAttribute("tableId");
        if (tableId != null) {
            cartService.save(tableId, productId);
        }
        return "redirect:/menu";
    }

    @PostMapping("/deleteCart")
    public String deleteCart(Long productId, HttpSession session) {
        Long tableId = (Long) session.getAttribute("tableId");
        if (tableId != null) {
            cartService.deleteByTableIdAndProductIdAndStatus(tableId, productId);
        }
        return "redirect:/menu";
    }

    @PostMapping("/plusCart")
    public String plusCart(Long productId, HttpSession session) {
        Long tableId = (Long) session.getAttribute("tableId");
        if (tableId != null) {
            cartService.plus(tableId, productId);
        }
        return "redirect:/menu";
    }

    @PostMapping("/minusCart")
    public String minusCart(Long productId, HttpSession session) {
        Long tableId = (Long) session.getAttribute("tableId");
        if (tableId != null) {
            cartService.minus(tableId, productId);
        }
        return "redirect:/menu";
    }

    @PostMapping("/order")
    public String order(HttpSession session) {
        Long tableId = (Long) session.getAttribute("tableId");
        if (tableId != null) {
            List<Cart> unOrderedCartList = cartService.findAllByTableIdAndStatus(tableId, (byte) 0);
            List<Cart> orderedCartList = cartService.findAllByTableIdAndStatus(tableId, (byte) 1);
            for (Cart unOrderedCart : unOrderedCartList) {
                boolean flag = false;
                for (Cart orderedCart : orderedCartList) {
                    if (orderedCart.getProductId().equals(unOrderedCart.getProductId())) {
                        orderedCart.setNumber((byte) (orderedCart.getNumber() + unOrderedCart.getNumber()));
                        cartService.saveCart(orderedCart);
                        cartService.deleteByTableIdAndProductIdAndStatus(tableId, orderedCart.getProductId());
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                unOrderedCart.setStatus((byte) 1);
                cartService.saveCart(unOrderedCart);
            }
        }
        return "redirect:/menu";
    }

    @PostMapping("/serverEnding")
    public String serverEnding(Long tableId){

        return "redirect:/menu";
    }
}
