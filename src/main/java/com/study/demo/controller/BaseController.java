package com.study.demo.controller;

import com.jfinal.core.Controller;

public class BaseController extends Controller
{
    public void index(){
        String url = getSessionAttr("url")==null?"":getSessionAttr("url").toString();
        if("/index".equalsIgnoreCase(url)){
            render("../index.html");
        }else{
            render("../view"+url+".html");
        }
        
    }
    
    public void QrCode(){
        renderQrCode("content", 100, 100);
    }
    
}
