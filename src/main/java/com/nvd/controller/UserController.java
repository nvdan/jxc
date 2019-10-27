package com.nvd.controller;

import com.nvd.bean.User;
import com.nvd.enums.JXCEnum;
import com.nvd.exception.JXCException;
import com.nvd.result.R;
import com.nvd.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@Slf4j
@Api(tags = "--用户模块--")
public class UserController {

    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "username",value = "用户名"),
            @ApiImplicitParam(name = "password",value = "密码")}
    )
    public ResultVO login(String username,String password){
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            log.info("【用户登录】 用户名或密码错误！ username = {},password = {}", username,password);
            throw new JXCException(JXCEnum.PARAM_ERROR.getCode(),"用户名或密码错误！");
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return R.error(JXCEnum.PARAM_ERROR.getCode(),"用户名或密码错误！");
        }
        return R.ok();
    }

    @GetMapping("/info")
    @ApiOperation(value = "获取当前登录用户的真实姓名(从session中获取)")
    public ResultVO getInfo(){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if(user == null){
            log.info("【获取登录用户的真实姓名】 用户未登录 user = {}",user);
            throw new JXCException(JXCEnum.USER_NOT_LOGIN);
        }
        String username = user.getRealname();
        return R.ok(username);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "退出登录")
    public ResultVO logout(){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(JXCEnum.USER_LOGOUT_ERROR);
        }
        return R.ok();
    }
}
