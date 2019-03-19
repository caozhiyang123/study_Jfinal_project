package com.study.demo.controller;


import com.jfinal.core.Controller;

public class HelloController extends Controller {
    public void index() {
       renderText("Hello JFinal World.");
    }
    
    public void doLogin(){
        String name = getPara(0);
        String pass = getPara(1);
        if("admin".equals(name) && "admin".equals(pass)){
            renderText("login success: name "+name+",password "+pass);
        }
    }
    
}