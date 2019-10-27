package com.nvd.service;

import com.github.pagehelper.PageInfo;
import com.nvd.bean.Sale;

import java.math.BigDecimal;

public interface SaleService {

    /*保存销售记录*/
    void saveSale(Sale sale);

    /*分页查询销售记录并排序*/
    PageInfo<Sale> findSaleAndSort(Integer currentPage,Integer pageSize,Integer flag);

}
