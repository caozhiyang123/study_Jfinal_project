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
import com.study.demo.controller.HelloController;
import com.study.demo.controller.LoginController;

public class DemoConfig extends JFinalConfig {
 
    public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class, 80, true);
    }
 
    public void configConstant(Constants me) {
       me.setDevMode(true);
    }
    
    public void configRoute(Routes me) {
        me.setMappingSuperClass(false);
       me.add("/hello", HelloController.class,"doLogin/name-pass");
       me.add("/login",LoginController.class,"doLogin/name-pass");
    }
    
    public void configEngine(Engine me) {}
    public void configPlugin(Plugins me) {}
    public void configInterceptor(Interceptors me) {}
    public void configHandler(Handlers me) {}
}