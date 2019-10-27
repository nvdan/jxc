package com.nvd.controller;

import com.github.pagehelper.PageInfo;
import com.nvd.bean.Sale;
import com.nvd.enums.JXCEnum;
import com.nvd.exception.JXCException;
import com.nvd.form.SaleForm;
import com.nvd.result.R;
import com.nvd.service.SaleService;
import com.nvd.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/sale")
@Api(tags = "销售记录模块")
@Slf4j
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/add")
    @ApiOperation(value = "保存销售记录")
    public ResultVO add(@Valid SaleForm saleForm, BindingResult result){
        if(result.hasErrors()){
            String msg = result.getFieldError().getDefaultMessage();
            log.info("【保存销售记录】 参数不合法 msg = {}",msg);
            throw new JXCException(JXCEnum.PARAM_ERROR.getCode(),msg);
        }
        Sale sale = new Sale();
        BeanUtils.copyProperties(saleForm,sale);
        saleService.saveSale(sale);
        return R.ok();
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页查询销售记录并排序")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "当前页",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示条数",defaultValue = "5"),
            @ApiImplicitParam(name = "flag",value = "根据flag排序",defaultValue = "0")
    })
    public ResultVO list(Integer currentPage,Integer pageSize,Integer flag){
        PageInfo<Sale> pageInfo = saleService.findSaleAndSort(currentPage, pageSize, flag);
        return R.ok(pageInfo);
    }
}
