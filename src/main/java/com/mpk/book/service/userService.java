package com.mpk.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mpk.book.cmmon.R;
import com.mpk.book.pojo.User;


public interface userService extends IService<User> {

    R<String> login(String username, String password);

    R<String> delete(String username);

    R<String> add(User user);

    R<String> register(User user);
}
