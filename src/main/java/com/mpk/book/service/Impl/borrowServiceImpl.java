package com.mpk.book.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mpk.book.mapper.bookMapper;
import com.mpk.book.mapper.borrowMapper;
import com.mpk.book.mapper.userMapper;
import com.mpk.book.pojo.Book;
import com.mpk.book.pojo.Borrow;
import com.mpk.book.pojo.User;
import com.mpk.book.service.borrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class borrowServiceImpl extends ServiceImpl<borrowMapper, Borrow> implements borrowService {
    @Autowired
    private borrowMapper borrowMapper;
    @Autowired
    private bookMapper bookMapper;
    @Autowired
    private userMapper userMapper;

    @Override
    public String borrowBook(Integer userId, Integer bookId) {
        User user = userMapper.selectById(userId);
        Book book = bookMapper.selectById(bookId);
        if (user != null) {
            if (user.getSize() > 0) {
                if (book.getSize() > 0) {
                    // 借书
                    Borrow borrow = new Borrow();
                    borrow.setBookId(bookId);
                    borrow.setUserId(userId);
                    try {
                        borrowMapper.insert(borrow);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    // 更新书籍数量
                    book.setSize(book.getSize()-1);
                    bookMapper.updateById(book);
                    // 更新用户书籍数量
                    user.setSize(user.getSize()-1);
                    userMapper.updateById(user);
                    return "借书成功";
                } else {
                    return "书籍数量不足";
                }
            } else {
                return "用户书籍数量已达到上限";
            }
        } else {
            return "借书失败";
        }
    }

    @Override
    public String returnBook(Integer userId, Integer bookId) {
        User user = userMapper.selectById(userId);
        Book book = bookMapper.selectById(bookId);
        LambdaQueryWrapper<Borrow> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Borrow::getUserId, userId).eq(Borrow::getBookId, bookId);
        Borrow borrow = borrowMapper.selectOne(queryWrapper);
        if (borrow != null) {
            // 还书
            borrowMapper.deleteById(borrow.getId());
            // 更新书籍数量
            book.setSize(book.getSize()+1);
            bookMapper.updateById(book);
            // 更新用户书籍数量
            user.setSize(user.getSize()+1);
            userMapper.updateById(user);
            return "还书成功";
        } else {
            return "借书记录为空";   }
        }


}
