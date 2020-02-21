package com.zab.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zab.mybatis.beans.User;
import com.zab.mybatis.common.Msg;
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
    public Msg findAll() {
        List<User> users = userMapper.findAll();
        int i = 1 / 0;
       /* int[] ints = {1,2,3,4};
        System.out.println(ints[5]);*/
        return new Msg("0", "查询成功", users);
    }

    @Override
    public Msg selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return new Msg("0", "查询成功", user);
    }

    @Override
    public Msg insert(User user) {
        int result = userMapper.insert(user);
        if (result == 1) {
            return new Msg("0", "新增成功", result);
        }
        return new Msg("1", "新增失败", result);
    }

    @Override
    public Msg findByPaging(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> userList = userMapper.findByPaging();
        return new Msg("0", "查询成功", userList);
    }
}
