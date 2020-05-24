package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.po.Cart;

import java.util.List;

public interface CartService {
    void saveCart(Cart cart);

    List<Cart> findAllByTableId(Long tid);

    List<Cart> findAllByTableIdAndStatus(Long tid, Byte status);

    List<Cart> findAllByTableIdToPage(Long tid);

    Double getTotalPriceByTableId(Long tid);

    void save(Long tid, Long pid);

    void delete(Long tid, Long pid);

    void deleteByTableIdAndProductIdAndStatus(Long tid, Long pid);

    void deleteByTableId(Long tid);

    void plus(Long tid, Long pid);

    void minus(Long tid, Long pid);
}
