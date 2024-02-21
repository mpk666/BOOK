package com.mpk.book.service.Impl;

import cn.dev33.satoken.stp.StpInterface;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mpk.book.mapper.userMapper;
import com.mpk.book.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限加载接口实现类
 */
@Component    // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
@Service
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    userMapper userMapper;

    /**
     * 返回一个账号所拥有的权限码集合 
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        return null;

    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        String id = (String) loginId;
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(User::getId,id);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        String role = user.getRole();
        List<String> list = new ArrayList<>();
        if (role.equals("admin")) {
            list.add("admin");
        }else if(role.equals("user")) {
            list.add("user");
        }
        return list;
    }

}
