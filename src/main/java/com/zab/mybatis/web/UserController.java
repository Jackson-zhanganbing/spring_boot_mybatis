package com.zab.mybatis.web;

import com.zab.mybatis.beans.User;
import com.zab.mybatis.common.Msg;
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
    public Msg findAll(){
        return userService.findAll();
    }

    @PostMapping("/findByPage")
    public Msg findByPaging(Integer pageNum, Integer pageSize){
        return userService.findByPaging(pageNum,pageSize);
    }

    @PostMapping("/selectByPrimaryKey")
    public Msg selectByPrimaryKey(Integer id){
        return userService.selectByPrimaryKey(id);
    }

    @PostMapping("/insert")
    public Msg insert(@RequestBody User user){
        return userService.insert(user);
    }
}
