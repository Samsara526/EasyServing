package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.po.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order getOne(Long id);

    void save(Order order);
}
