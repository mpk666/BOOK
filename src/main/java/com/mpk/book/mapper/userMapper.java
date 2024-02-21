package com.mpk.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mpk.book.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper extends BaseMapper<User> {

}
