package com.study.demo.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class MyJFinalConfig extends JFinalConfig {
    
    public void configRoute(Routes me) {
       me.setMappingSuperClass(false);
       me.add(new FrontRoutes());  // 前端路由
       me.add(new AdminRoutes());  // 后端路由
    }
    public void configConstant(Constants me) {
        me.setDevMode(true);
    }
    public void configEngine(Engine me) {}
    public void configPlugin(Plugins me) {}
    public void configInterceptor(Interceptors me) {}
    public void configHandler(Handlers me) {}
    
    public static void main(String[] args) {
        /**
         * 特别注意：IDEA 之下建议的启动方式，仅比 eclipse 之下少了最后一个参数
         */
//        JFinal.start("src/main/webapp", 80, "/");
        UndertowServer.start(MyJFinalConfig.class, 80, true);
    }
}