package com.study.demo.config;

import com.jfinal.config.Routes;
import com.study.demo.controller.BaseController;

public class FrontRoutes extends Routes {
    public void config() {
       add("/index", BaseController.class,"/renderIndex");
       add("/log", BaseController.class,"/renderBlog");
       add("/user", BaseController.class,"/renderLogin");
       add("/generate", BaseController.class,"/QrCode");
    }
}