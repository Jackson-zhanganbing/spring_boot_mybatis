package com.zab.mybatis.service;

import com.zab.mybatis.beans.User;
import com.zab.mybatis.common.GeneralResponse;

public interface UserService {

    GeneralResponse findAll();

    GeneralResponse selectByPrimaryKey(Integer id);

    GeneralResponse insert(User user);

    GeneralResponse findByPaging(Integer pageNum, Integer pageSize);
}
