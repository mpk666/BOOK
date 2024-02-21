package com.mpk.book.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;  
import lombok.Data;  
  
import java.io.Serializable;  
import java.util.Date;  
  
@Data  
@TableName("user")
public class User implements Serializable {  
  
    private static final long serialVersionUID = 1L;  
  
    @TableId(type= IdType.AUTO)
    private Integer id;  
  
    private String address;  
  
    private String avatar;  
  
    private Date birthday;  
  
    private String email;  
  
    private Integer identity;  
  
    private Integer isAdmin; // 通常使用布尔类型来表示是否是管理员，但这里使用了整数类型，需要根据业务逻辑进行转换  
  
    private String nickname;  
  
    private String password;  
  
    private Integer size;  
  
    private String tel;  
  
    private String username;

    private String role;
  
    // 如果需要其他属性或方法，可以在这里添加  
}