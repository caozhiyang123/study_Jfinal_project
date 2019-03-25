package com.study.demo.config;

import com.jfinal.config.Routes;
import com.study.demo.controller.BaseController;

public class FrontRoutes extends Routes {
    public void config() {
       setMappingSuperClass(false);
       add("/index", BaseController.class);
       add("/login", BaseController.class);
       add("/register", BaseController.class);
       add("/generate", BaseController.class,"/QrCode");
    }
}