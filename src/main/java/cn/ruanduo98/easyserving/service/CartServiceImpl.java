package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.dao.CartRepository;
import cn.ruanduo98.easyserving.dao.ProductRepository;
import cn.ruanduo98.easyserving.po.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<Cart> findAllByTableId(Long tid) {
        return cartRepository.findAllByTableId(tid);
    }

    @Override
    public List<Cart> findAllByTableIdToPage(Long tid) {
        List<Cart> orderedCarts = cartRepository.findAllByTableIdAndStatus(tid, (byte) 1);
        List<Cart> unorderedCarts = cartRepository.findAllByTableIdAndStatus(tid, (byte) 0);
        orderedCarts.addAll(unorderedCarts);
        return orderedCarts;
    }

    @Override
    public List<Cart> findAllByTableIdAndStatus(Long tid, Byte status) {
        return cartRepository.findAllByTableIdAndStatus(tid, status);
    }

    @Override
    public Double getTotalPriceByTableId(Long tid) {
        double total = 0;
        List<Cart> carts = findAllByTableId(tid);
        for (Cart cart : carts) {
            total += cart.getNumber() * productRepository.getOne(cart.getProductId()).getPrice();
        }
        return total;
    }

    @Override
    public void save(Long tid, Long pid) {
        if (cartRepository.findAllByTableIdAndProductIdAndStatus(tid, pid, (byte) 0) == null) {
            cartRepository.save(new Cart(tid, pid, (byte) 1, (byte) 0));
            return;
        }
        Cart cart = cartRepository.findAllByTableIdAndProductIdAndStatus(tid, pid, (byte) 0);
        cart.setNumber((byte) (cart.getNumber() + 1));
        cartRepository.save(cart);
    }

    @Override
    public void delete(Long tid, Long pid) {
        cartRepository.deleteByTableIdAndProductIdAndStatus(tid, pid, (byte) 0);
    }

    @Override
    public void deleteByTableIdAndProductIdAndStatus(Long tid, Long pid) {
        cartRepository.deleteByTableIdAndProductIdAndStatus(tid, pid, (byte) 0);
    }

    @Override
    public void plus(Long tid, Long pid) {
        Cart cart = cartRepository.findAllByTableIdAndProductIdAndStatus(tid, pid, (byte) 0);
        if (cart != null) {
            cart.setNumber((byte) (cart.getNumber() + 1));
            cartRepository.save(cart);
        }
    }

    @Override
    public void minus(Long tid, Long pid) {
        Cart cart = cartRepository.findAllByTableIdAndProductIdAndStatus(tid, pid, (byte) 0);
        if (cart != null && cart.getNumber() > 1) {
            cart.setNumber((byte) (cart.getNumber() - 1));
            cartRepository.save(cart);
        }
    }
}
