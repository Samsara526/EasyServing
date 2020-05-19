package cn.ruanduo98.easyserving.dao;

import cn.ruanduo98.easyserving.po.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
