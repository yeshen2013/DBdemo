package com.lyyexample.service;

import com.lyyexample.domain.User;

import java.util.List;

/**
 * Created by liuyangyang on 2018/4/15.
 */
public interface UserService {

    public User getByName(String name);

    public List<User> getAll();
}
