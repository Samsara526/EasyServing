package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.dao.OrderProductsRepository;
import cn.ruanduo98.easyserving.po.OrderProducts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    private final OrderProductsRepository orderProductsRepository;

    public OrderProductServiceImpl(OrderProductsRepository orderProductsRepository) {
        this.orderProductsRepository = orderProductsRepository;
    }

    @Override
    public void saveOrderProduct(OrderProducts orderProducts) {
        orderProductsRepository.save(orderProducts);
    }

    @Override
    public List<OrderProducts> findAllOrderProductsByOrderId(Long orderId) {
        return orderProductsRepository.findAllByOid(orderId);
    }
}
