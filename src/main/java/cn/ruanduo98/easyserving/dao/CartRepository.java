package cn.ruanduo98.easyserving.dao;

import cn.ruanduo98.easyserving.po.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByTableId(Long tid);

    Cart findByTableIdAndProductId(Long tid, Long pid);
}
