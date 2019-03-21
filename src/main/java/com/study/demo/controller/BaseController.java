package com.study.demo.controller;

import com.jfinal.core.Controller;

public class BaseController extends Controller
{
    public void renderIndex(){
        set("name", "admin").set("pass", "123").render("../index.html");
    }
    public void renderBlog(){
        render("../blog.html");
    }
    public void renderLogin(){
        render("../view/login.html");
    }
    
}
