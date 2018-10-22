package com.zab.mybatis.web;

import com.github.pagehelper.Page;
import com.zab.mybatis.beans.User;
import com.zab.mybatis.common.GeneralResponse;
import com.zab.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findAll")
    public GeneralResponse findAll(){
        return userService.findAll();
    }

    @PostMapping("/findByPage")
    public GeneralResponse findByPaging(Integer pageNum, Integer pageSize){
        return userService.findByPaging(pageNum,pageSize);
    }

    @PostMapping("/selectByPrimaryKey")
    public GeneralResponse selectByPrimaryKey(Integer id){
        return userService.selectByPrimaryKey(id);
    }

    @PostMapping("/insert")
    public GeneralResponse insert(@RequestBody User user){
        return userService.insert(user);
    }
}
