package com.study.demo.controller;

import com.jfinal.core.Controller;

public class BlogController extends Controller
{
    public void index(){
        render("blog.html");
    }
}
