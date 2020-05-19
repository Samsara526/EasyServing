package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.po.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartServiceImplTest {

    @Autowired
    private CartService cartService;

    @Test
    void saveCart() {
        Cart cart = new Cart((long) 1, (long) 1, (byte) 1, (byte) 1);
        cartService.saveCart(cart);
    }

    @Test
    void findAllByTableId() {
        System.out.println(cartService.findAllByTableId((long) 1));
    }
}