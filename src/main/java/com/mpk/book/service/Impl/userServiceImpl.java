package com.mpk.book.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mpk.book.cmmon.R;
import com.mpk.book.mapper.userMapper;
import com.mpk.book.pojo.User;
import com.mpk.book.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl extends ServiceImpl<userMapper, User> implements userService {
    @Autowired
    private userMapper userMapper;

    @Override
    public R<String> login(String username, String password) {
        // 调用mapper层的查询方法，根据用户名查询用户信息
        LambdaQueryWrapper<User> objectLambdaQueryWrapper = Wrappers.lambdaQuery();
        objectLambdaQueryWrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(objectLambdaQueryWrapper);
        if (user == null) {

            return R.error("用户不存在");
        }else if (!user.getPassword().equals(password)){
            return R.error("密码错误");
        }else {
            StpUtil.login(user.getId());
            return R.success("登录成功");
        }
    }

    @Override
    public R<String> delete(String username) {
        QueryWrapper<User> objectQueryWrapper = Wrappers.query();
        objectQueryWrapper.eq("username", username);
        userMapper.delete(objectQueryWrapper);
        return R.success("删除成功");
    }

    @Override
    public R<String> add(User user) {
        // 检查用户名是否已存在
        User user1 = userMapper.selectById(user.getId());
        if (user1 != null) {
            return R.error("用户名已存在");
        }else {
            userMapper.insert(user);
            return R.success("添加成功");
        }

    }
    // 注册方法
    @Override
    public R<String> register(User user) {
        // 检查用户名是否已存在
        User user1 = userMapper.selectById(user.getId());
        if (user1 != null) {
            return R.error("用户名已存在");
        }else {
            userMapper.insert(user);
            return R.success("注册成功");
        }


    }
}
