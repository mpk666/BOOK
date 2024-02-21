package com.mpk.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mpk.book.pojo.Book;

public interface bookService extends IService<Book>  {
    String add(Book book);

    String updateBok(Book book);

    Book find(Integer id);

    String delete(Integer id);
}
