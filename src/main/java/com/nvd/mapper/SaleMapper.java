package com.nvd.mapper;

import com.github.pagehelper.PageInfo;
import com.nvd.bean.Sale;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SaleMapper extends Mapper<Sale> {

    /*分页查询销售记录并排序*/
    List<Sale> findAllSaleSortByFlag(@Param("flag") Integer flag);
}
