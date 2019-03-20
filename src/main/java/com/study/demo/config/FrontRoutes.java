package com.study.demo.config;

import com.jfinal.config.Routes;
import com.study.demo.controller.BlogController;
import com.study.demo.controller.IndexController;

public class FrontRoutes extends Routes {
    public void config() {
     // 这里配置只对 FrontRoutes 下的路由有效，建议这样配置以提升性能
        setMappingSuperClass(true);
       add("/index", IndexController.class,"/");
       add("/log", BlogController.class,"/");
    }
}