package com.mpk.book.controller;

import com.mpk.book.annotation.NeedAuth;
import com.mpk.book.cmmon.R;
import com.mpk.book.pojo.Book;
import com.mpk.book.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class bookController {

    @Autowired
    private bookService bookService;

    //新增图书
    @NeedAuth(needAuth = true,needRole = "admin")
    @PostMapping("/add")
    public R<String> add(@RequestBody Book book){
        return R.success(bookService.add(book));
    }
    //编辑图书
    @NeedAuth(needAuth = true,needRole = "admin")
    @PostMapping("/update")
    public R<String> update(@RequestBody Book book){
        return R.success(bookService.updateBok(book));
    }
    //查询图书
    @NeedAuth(needAuth = true)
    @PostMapping("/find")
    public R<Book> find(@RequestParam Integer id){
        return R.success(bookService.find(id));
    }
    //删除图书
    @NeedAuth(needAuth = true,needRole = "admin")
    @PostMapping("/delete")
    public R<String> delete(@RequestParam Integer id){
        return R.success(bookService.delete(id));
    }
}
