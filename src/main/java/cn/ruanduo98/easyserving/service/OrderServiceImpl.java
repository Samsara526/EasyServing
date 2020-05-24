package cn.ruanduo98.easyserving.service;


import cn.ruanduo98.easyserving.dao.OrderRepository;
import cn.ruanduo98.easyserving.po.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOne(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
