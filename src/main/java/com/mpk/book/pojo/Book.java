package com.mpk.book.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;  
import lombok.Data;  
  
import java.io.Serializable;  
import java.util.Date;  
  
@Data  
@TableName("book")  
public class Book implements Serializable {  
  
    private static final long serialVersionUID = 1L;  
  
    @TableId(type= IdType.AUTO)
    private Integer id;  
  
    private String author; // 作者  
  
    private String isbn; // ISBN号  
  
    private String name; // 书名  
  
    private Integer pages; // 页数  
  
    private Double price; // 价格  
  
    private String publish; // 出版社  
  
    private Date publishTime; // 出版时间  
  
    private Integer size; // 尺寸（可能是书籍的大小或页数等，具体根据业务需求）  
  
    private String translate; // 译者  
  
    private String type; // 书籍类型（例如小说、科技、教育等）  
  
    // 如果需要其他属性或方法，可以在这里添加  
}