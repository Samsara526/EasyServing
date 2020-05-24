package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.po.Product;

public interface ProductService {
    Product getProductById(Long id);

    Double getPriceById(Long id);
}
