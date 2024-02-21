package com.mpk.book.controller;

import com.mpk.book.annotation.NeedAuth;
import com.mpk.book.cmmon.R;
import com.mpk.book.service.borrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrow")
public class borrowController {
    @Autowired
    private borrowService borrowService;

    //借阅图书
    @NeedAuth(needAuth = true)
    @PostMapping("/borrowBook")
    public R<String> borrowBook(Integer userId, Integer bookId) {
        return R.success(borrowService.borrowBook(userId, bookId));
    }

    //归还图书
    @NeedAuth(needAuth = true)
    @PostMapping("/returnBook")
    public R<String> returnBook(Integer userId, Integer bookId) {
        return R.success(borrowService.returnBook(userId, bookId));
    }
}
