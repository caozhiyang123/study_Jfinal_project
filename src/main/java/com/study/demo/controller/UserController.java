package com.study.demo.controller;

import com.jfinal.core.Controller;
import com.study.demo.vo.User;

public class UserController extends Controller
{
    public void list(){
        User user = new User(121213223L,"admin",121232434L,12121999L);
        renderJson(user);
    }
}
