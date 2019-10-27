package com.nvd.service.impl;

import com.nvd.bean.User;
import com.nvd.mapper.UserMapper;
import com.nvd.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /*登录*/
    @Override
    public User login(String username) {
        User param = new User();
        param.setUsername(username);
        User user = userMapper.selectOne(param);
        return user;
    }
}
