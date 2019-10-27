package com.nvd.service.impl;

import com.nvd.bean.Product;
import com.nvd.mapper.ProductMapper;
import com.nvd.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    /*查询全部商品*/
    @Override
    public List<Product> findAll() {
        List<Product> productList = productMapper.selectAll();
        return productList;
    }

    /*查询商品库存*/
    @Override
    public Integer findCount(Integer id) {
        Integer quantity = productMapper.findQuantityById(id);
        return quantity;
    }
}
