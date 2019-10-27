package com.nvd.controller;

import com.nvd.bean.Product;
import com.nvd.result.R;
import com.nvd.service.ProductService;
import com.nvd.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@Api(tags = "--商品模块--")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    @ApiOperation(value = "查询全部商品信息")
    public ResultVO list(){
        List<Product> productList = productService.findAll();
        return R.ok(productList);
    }

    @GetMapping("/quantity/{id}")
    @ApiOperation(value = "查询商品库存")
    @ApiImplicitParam(name = "id",value = "商品编号")
    public ResultVO getQuantity(@PathVariable Integer id){
        Integer count = productService.findCount(id);
        return R.ok(count);
    }
}
