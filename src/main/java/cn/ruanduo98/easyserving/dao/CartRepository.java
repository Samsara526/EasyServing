package cn.ruanduo98.easyserving.dao;

import cn.ruanduo98.easyserving.po.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByTableId(Long tid);

    List<Cart> findAllByTableIdAndStatus(Long tid, Byte status);

    Cart findByTableIdAndProductId(Long tid, Long pid);

    Cart findAllByTableIdAndProductIdAndStatus(Long tid, Long pid, Byte status);

    @Transactional
    void deleteByTableIdAndProductIdAndStatus(Long tid, Long pid, Byte status);
}
