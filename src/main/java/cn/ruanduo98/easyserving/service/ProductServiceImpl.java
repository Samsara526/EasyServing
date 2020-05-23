package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.dao.ProductRepository;
import cn.ruanduo98.easyserving.po.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getOne(id);
    }

}
