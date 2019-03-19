package com.study.demo.controller;

import com.jfinal.core.Controller;

public class LoginController extends Controller
{

    public void doLogin(){
        String name = getPara(0);
        String pass = getPara(1);
        if("admin".equals(name) && "admin".equals(pass)){
            renderText("login success: "+ name+" ,"+pass);
        }
        
    }
    

}
