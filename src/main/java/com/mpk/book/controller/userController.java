package com.mpk.book.controller;

import com.mpk.book.annotation.NeedAuth;
import com.mpk.book.cmmon.R;
import com.mpk.book.pojo.User;
import com.mpk.book.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userServise;

    @PostMapping("/login")
    public R<String> login(@RequestParam String username, @RequestParam String password){
        return userServise.login(username, password);

    }
    //注册
    @PostMapping("/register")
    public R<String> register(@RequestBody User user){
        return userServise.register(user);
    }
    //删除读者
    @NeedAuth(needAuth = true,needRole = "admin")
    @PostMapping("/delete")
    public R<String> delete(@RequestParam String username){
        return userServise.delete(username);
    }
    //添加读者
    @NeedAuth(needAuth = true,needRole = "admin")
    @PostMapping("/add")
    public R<String> add(@RequestBody User user){

        return userServise.add(user);
    }
}
