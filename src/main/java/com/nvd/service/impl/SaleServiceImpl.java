package com.nvd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nvd.bean.Product;
import com.nvd.bean.Sale;
import com.nvd.enums.JXCEnum;
import com.nvd.exception.JXCException;
import com.nvd.mapper.ProductMapper;
import com.nvd.mapper.SaleMapper;
import com.nvd.service.ProductService;
import com.nvd.service.SaleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private ProductMapper productMapper;

    /*保存销售记录*/
    @Override
    @Transactional
    public void saveSale(Sale sale) {
        BigDecimal totalPrice = sale.getPrice().multiply(new BigDecimal(sale.getQuantity()));
        sale.setTotalPrice(totalPrice);
        sale.setUserId(1);
        int count = saleMapper.insertSelective(sale);
        if(count != 1){
            log.error("【添加销售记录】 添加销售记录失败！ count = {}", count);
            throw new JXCException(JXCEnum.SALE_ADD_ERROR);
        }
        Integer update = productMapper.update(sale.getQuantity(), sale.getProductId());
        if(update != 1){
            log.error("【修改商品信息】 修改商品信息失败！ update = {}",update);
            throw new JXCException(JXCEnum.PRODUCT_UPDATE_ERROR);
        }
    }

    @Override
    public PageInfo<Sale> findSaleAndSort(Integer currentPage, Integer pageSize, Integer flag) {
        PageHelper.startPage(currentPage,pageSize);
        List<Sale> list = saleMapper.findAllSaleSortByFlag(flag);
        PageInfo<Sale> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
