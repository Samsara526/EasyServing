package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.po.OrderProducts;

import java.util.List;

public interface OrderProductService {
    void saveOrderProduct(OrderProducts orderProducts);

    List<OrderProducts> findAllOrderProductsByOrderId(Long orderId);
}
