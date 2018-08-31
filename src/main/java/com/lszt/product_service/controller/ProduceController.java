package com.lszt.product_service.controller;

import com.lszt.product_service.domain.Product;
import com.lszt.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/product")
public class ProduceController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductService productService;

    @RequestMapping("list")
    public Object list() {
        return productService.listProduct();
    }

    @RequestMapping("find")
    public Object findById(@RequestParam("id") int id) {
/*        try {
            //线程暂停
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Product product = productService.findById(id);
        Product result = new Product();
        //拷贝对象 伪代码
        BeanUtils.copyProperties(product, result);
        result.setName(result.getName() + "data from prot=" + port);
        return result;
    }
}
