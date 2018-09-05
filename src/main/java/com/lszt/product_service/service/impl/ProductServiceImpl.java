package com.lszt.product_service.service.impl;

import com.lszt.product_service.domain.Product;
import com.lszt.product_service.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Map<Integer, Product> dapMap = new HashMap<>();

    private final Logger logger = LoggerFactory.getLogger(getClass());

    static {
        Product p1 = new Product(1, "ipx", 999, 10);
        Product p2 = new Product(2, "冰箱", 888, 15);
        Product p3 = new Product(3, "洗衣机", 777, 20);
        Product p4 = new Product(4, "电视", 666, 25);
        Product p5 = new Product(5, "电话", 555, 30);
        Product p6 = new Product(6, "汽车", 444, 35);
        dapMap.put(p1.getId(), p1);
        dapMap.put(p2.getId(), p2);
        dapMap.put(p3.getId(), p3);
        dapMap.put(p4.getId(), p4);
        dapMap.put(p5.getId(), p5);
        dapMap.put(p6.getId(), p6);
    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = dapMap.values();
        List<Product> list = new ArrayList<>(collection);
        logger.info("service listProduct");
        return list;
    }

    @Override
    public Product findById(int id) {
        return dapMap.get(id);
    }
}
