package com.zab.mybatis.service;

import com.zab.mybatis.beans.User;
import com.zab.mybatis.common.Msg;

public interface UserService {

    Msg findAll();

    Msg selectByPrimaryKey(Integer id);

    Msg insert(User user);

    Msg findByPaging(Integer pageNum, Integer pageSize);
}
