package com.scm.controller;
/*
用户查看 /scm/users/show
用户修改 /scm/users/modify
用户增加 /scm/users/add
密码重置 /scm/users/reset
用户删除 /scm/users/delete
用户自己密码修改 /scm/users/password
 */
import com.scm.entity.UsersEntity;
import com.scm.model.PageUserModel;
import com.scm.model.UserModel;
import com.scm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/scm/users/show",method = RequestMethod.GET)
    @ResponseBody
    public List<PageUserModel> GetShowUser(){
        return userService.findAllUser();
    }
    @RequestMapping(value = "/scm/users/modify",method = RequestMethod.POST)
    @ResponseBody
    public Integer PostModifyUser(UserModel userModel){
       return userService.ModifyUser(userModel);
    }

    @RequestMapping(value = "/scm/users/add",method = RequestMethod.POST)
    @ResponseBody
    public Integer PostAddUser(UserModel userModel){
        return userService.AddUser(userModel);
    }

    @RequestMapping(value = "/scm/users/reset/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public Integer PostResetUser(@PathVariable Integer userId){
        return userService.ResetUser(userId);
    }

    @RequestMapping(value = "/scm/users/delete/{userId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Integer PostDeleteUser(@PathVariable Integer userId){
       return userService.DeleteUser(userId);
    }

    @RequestMapping(value = "/scm/users/password",method = RequestMethod.POST)
    @ResponseBody
    public Integer PostChangePassword(@RequestParam String OldPassword, @RequestParam String NewPassword, @RequestParam Integer userId)
    {
        try {
            return userService.UserPasswordModify(userId,OldPassword,NewPassword);
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping(value = "/scm/users/id/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public PageUserModel GetUsersInfo(@PathVariable Integer userId){
        return userService.findUsersById(userId);
    }
}
