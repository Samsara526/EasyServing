package cn.ruanduo98.easyserving.dao;

import cn.ruanduo98.easyserving.po.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {
}
