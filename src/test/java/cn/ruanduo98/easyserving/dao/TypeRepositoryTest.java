package cn.ruanduo98.easyserving.dao;

import cn.ruanduo98.easyserving.po.Product;
import cn.ruanduo98.easyserving.po.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TypeRepositoryTest {

    @Autowired
    private TypeRepository typeRepository;

    @Test
    void findAll() {
        List<Type> list = typeRepository.findAll();
        for (Type type : list) {
            System.out.println(type);
            List<Product> products = type.getProducts();
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}