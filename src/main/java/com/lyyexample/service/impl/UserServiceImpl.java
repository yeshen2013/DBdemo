package com.lyyexample.service.impl;

import com.lyyexample.domain.User;
import com.lyyexample.mapper.UserMapper;
import com.lyyexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuyangyang on 2018/4/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByName(String name) {
        User userInfo = userMapper.getUserInfo(name);
        return userInfo;
    }

    @Override
    public List<User> getAll() {
        List<User> all = userMapper.getAll();
        return all;
    }
}
