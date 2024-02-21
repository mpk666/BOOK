package com.mpk.book.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mpk.book.mapper.bookMapper;
import com.mpk.book.pojo.Book;
import com.mpk.book.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bookServiceImpl extends ServiceImpl<bookMapper, Book> implements bookService{
    @Autowired
    bookMapper bookMapper;
    @Override
    public String add(Book book) {
        if (book == null) {
            return "添加失败";
        }else {
        bookMapper.insert(book);
        return  "添加成功";
        }
    }

    @Override
    public String updateBok(Book book) {
        if (book == null) {
            return "更新失败";
        }else {
            bookMapper.updateById(book);
            return  "更新成功";
        }
    }

    @Override
    public Book find( Integer id) {
        Book book = bookMapper.selectById(id);
        return book;
    }

    @Override
    public String delete( Integer id) {
        if (id == null) {
            return "删除失败";
        }else {
        bookMapper.deleteById(id);
        return   "删除成功";
        }
    }
}
