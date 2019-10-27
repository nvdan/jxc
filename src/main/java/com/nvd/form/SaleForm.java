package com.nvd.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel(value = "销售记录信息")
@Data
public class SaleForm {

    @NotNull(message = "商品编号为必传项！")
    @ApiModelProperty(value = "商品编号")
    private Integer productId;

    @ApiModelProperty(value = "商品价格")
    @NotNull(message = "商品价格为必传项！")
    private BigDecimal price;

    @ApiModelProperty(value = "商品数量")
    @NotNull(message = "商品数量为必传项！")
    private Integer quantity;
}
