package com.zab.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zab.mybatis.beans.User;
import com.zab.mybatis.common.GeneralResponse;
import com.zab.mybatis.mapper.UserMapper;
import com.zab.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public GeneralResponse findAll() {
        List<User> users = userMapper.findAll();
        int i = 1 / 0;
       /* int[] ints = {1,2,3,4};
        System.out.println(ints[5]);*/
        return new GeneralResponse("0", "查询成功", "查询成功", users);
    }

    @Override
    public GeneralResponse selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return new GeneralResponse("0", "查询成功", "查询成功", user);
    }

    @Override
    public GeneralResponse insert(User user) {
        int result = userMapper.insert(user);
        if (result == 1) {
            return new GeneralResponse("0", "新增成功", "新增成功", result);
        }
        return new GeneralResponse("1", "新增失败", "新增失败", result);
    }

    @Override
    public GeneralResponse findByPaging(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> userList = userMapper.findByPaging();
        return new GeneralResponse("0", "查询成功", "查询成功", userList);
    }
}
