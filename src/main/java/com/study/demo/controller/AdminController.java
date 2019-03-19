package com.study.demo.controller;

import com.jfinal.core.Controller;

public class AdminController extends Controller
{
    public void login(){
        String name = getPara(0);
        String pass = getPara(1);
        if("admin".equals(name) && "admin".equals(pass)){
            renderText("login success: "+ name+" ,"+pass);
        }
    }
}
