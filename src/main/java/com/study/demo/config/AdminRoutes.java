package com.study.demo.config;

import com.jfinal.config.Routes;
import com.study.demo.controller.AdminController;
import com.study.demo.controller.UserController;

public class AdminRoutes extends Routes {
    public void config() {
       add("/admin", AdminController.class,"login/name-pass");
       add("/user", UserController.class,"list");
    }
}