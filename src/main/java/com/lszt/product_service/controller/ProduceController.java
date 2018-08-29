package com.lszt.product_service.controller;

import com.lszt.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProduceController {
    @Autowired
    private ProductService productService;

    @RequestMapping("list")
    public Object list() {
        return productService.listProduct();
    }

    @RequestMapping("id")
    public Object findById(@RequestParam("id") int id) {
        return productService.findById(id);
    }
}
