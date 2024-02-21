package com.mpk.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mpk.book.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface bookMapper extends BaseMapper<Book> {

}
