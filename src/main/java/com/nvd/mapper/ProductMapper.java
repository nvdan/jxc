package com.nvd.mapper;

import com.nvd.bean.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface ProductMapper extends Mapper<Product> {

    @Update("update product set quantity = quantity - #{subQuantity} where id = #{id}")
    Integer update(@Param("subQuantity")Integer subQuantity,@Param("id")Integer id);

    @Select("select quantity from product where id = #{id}")
    Integer findQuantityById(@Param("id") Integer id);
}
