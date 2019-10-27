package com.nvd.shiro;

import com.nvd.service.UserService;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    @Autowired
    private CustomRealm realm;
    @Autowired
    private UserService userService;

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/user/**", "anon");
        definition.addPathDefinition("/swagger-ui.html","anon");
        definition.addPathDefinition("/swagger-resources/**","anon");
        definition.addPathDefinition("/v2/**","anon");
        definition.addPathDefinition("/webjars/**","anon");
        definition.addPathDefinition("/**", "authc");
        return definition;
    }

}
