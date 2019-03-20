package com.study.demo.controller;

import com.jfinal.core.Controller;
import com.study.demo.vo.User;

public class UserController extends Controller
{
    public void list(){
        User user = new User(121213223L,"admin",121232434L,12121999L);
        renderJson(user);
    }
    
    public void save(){
//        user.save();
//        renderText("name: "+getPara(0)+" - "+getPara(1));
//        renderText("name: "+getPara("name")+"-"+getPara("facebookId"));
    }
}
