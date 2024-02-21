package com.mpk.book.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;  
import lombok.Data;  
import java.io.Serializable;  
import java.util.Date;  
  
@Data  
@TableName("borrow")  
public class Borrow implements Serializable {  
  
    private static final long serialVersionUID = 1L;  
  
    @TableId(type= IdType.AUTO)
    private Integer id;  
  
    private Integer bookId;  
  
    private Date createTime;  
  
    private Date endTime;  
  
    private Integer ret;
  
    private Date updateTime;  
  
    private Integer userId;  
  
    // 如果需要其他属性或方法，可以在这里添加  
}