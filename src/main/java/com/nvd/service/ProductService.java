package com.nvd.service;

import com.nvd.bean.Product;

import java.util.List;

public interface ProductService {

    /*查询全部商品*/
    List<Product> findAll();

    /*查询商品库存*/
    Integer findCount(Integer id);
}
