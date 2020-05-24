package cn.ruanduo98.easyserving.dao;

import cn.ruanduo98.easyserving.po.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {
    List<OrderProducts> findAllByOid(Long oid);
}
