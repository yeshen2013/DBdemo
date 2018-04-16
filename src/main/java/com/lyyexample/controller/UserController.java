package com.lyyexample.controller;

import com.lyyexample.common.ResponseModel;
import com.lyyexample.domain.User;
import com.lyyexample.mapper.UserMapper;
import com.lyyexample.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liuyangyang on 2018/4/15.
 */
@RestController
@RequestMapping("user")
public class UserController {

    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/getByName/{name}")
    public ResponseModel getByName(@PathVariable("name") String name){
        logger.info("getByName:"+name);
        if(StringUtils.isNotBlank(name)){
            User userInfo = userMapper.getUserInfo(name);
            return ResponseModel.ok(userInfo);
        }else{
            return ResponseModel.fail("name不能为空！");
        }

    }

    @GetMapping("/getAll")
    public ResponseModel getAll(){
        List<User> all = userMapper.getAll();
        return new ResponseModel(all);
    }

    @GetMapping("/selectByName/{name}")
    public ResponseModel selectByName(@PathVariable("name") String name){
        if(StringUtils.isNotBlank(name)){
            User user = userService.getByName(name);
            return new ResponseModel(user);
        } else {
            return ResponseModel.fail("name不能为空！");
        }
    }

    @GetMapping("/selectAll")
    public ResponseModel getAllUser(){
        List<User> all = userService.getAll();
        return new ResponseModel(all);
    }

    @PostMapping("/add")
    public ResponseModel add(@RequestBody User user){
        boolean flag = userMapper.insert(user.getName(), user.getPassWord(), new Date(), new Date());
        if(flag){
            return ResponseModel.ok();
        } else {
            return ResponseModel.fail();
        }
    }

    @PostMapping("/update")
    public ResponseModel update(@RequestBody User user){
        boolean flag = userMapper.update(user.getId(), user.getName(), user.getPassWord(), new Date());
        if(flag){
            return ResponseModel.ok();
        } else {
            return ResponseModel.fail();
        }
    }

    @GetMapping("/deleteByName/{name}")
    public ResponseModel deleteByName(@PathVariable("name") String name){
        boolean flag = userMapper.deleteByName(name);
        if(flag){
            return ResponseModel.ok();
        } else {
            return ResponseModel.fail();
        }
    }

    @GetMapping("/deleteById/{id}")
    public ResponseModel deleteById(@PathVariable("id") int id){
        boolean flag = userMapper.deleteById(id);
        if(flag){
            return ResponseModel.ok();
        } else {
            return ResponseModel.fail();
        }
    }

}
