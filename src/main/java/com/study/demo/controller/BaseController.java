package com.study.demo.controller;

import com.jfinal.core.Controller;
import com.study.demo.render.PhotoQrCode;

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
        render(new PhotoQrCode("http://www.baifenjy.com", 150, 150
                ,"http://www.gtdblog.com/wp/wp-content/uploads/2017/09/meyou4-1.png",0xff9966));
    }
    
}
