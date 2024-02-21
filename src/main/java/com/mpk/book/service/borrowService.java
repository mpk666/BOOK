package com.mpk.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mpk.book.pojo.Borrow;

public interface borrowService extends IService<Borrow> {
    String borrowBook(Integer userId, Integer bookId);

    String returnBook(Integer userId, Integer bookId);
}
