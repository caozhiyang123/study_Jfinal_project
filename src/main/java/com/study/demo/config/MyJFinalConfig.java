package com.study.demo.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import com.study.demo.model.MappingKit;

public class MyJFinalConfig extends JFinalConfig {
    
    public void configRoute(Routes me) {
        //希望Contorller类的超类中的方法也被映射为 action,可以设置true,一般设置false
       me.setMappingSuperClass(false);
       me.add(new FrontRoutes());  // front route
       me.add(new AdminRoutes());  // server route
    }
    
    public void configConstant(Constants me) {
     // loading a little config,then can by method PropKit.get(...) get value
        PropKit.use("properties/application.properties");
        me.setDevMode(PropKit.getBoolean("DEV_MODE"));
        me.setError500View("/view/500.html");
        me.setError404View("/view/404.html");
    }
    
    public void configEngine(Engine me) {
        me.addSharedFunction("/view/common/layout.html");
        me.addSharedFunction("/view/common/paginate.html");
        me.addSharedFunction("/view/admin/common/layout.html");
    }
    
    public void configPlugin(Plugins me) {
     // C3p0 database connection pool plugin
        DruidPlugin core = createC3p0Plugin();
        core.setTestWhileIdle(true);
        me.add(core);

     //  ActiveRecord database access plugin
        ActiveRecordPlugin arp_core = new ActiveRecordPlugin("core", core);
        arp_core.setShowSql(true);
        me.add(arp_core);
        
     // ActiveRecordPlugin mapping 2 db(VO)
        MappingKit.mapping(arp_core);
    }
    
    public static DruidPlugin createC3p0Plugin() {
        return new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.user"), PropKit.get("jdbc.password").trim());
    }
    
    /**
     * global interceptor
     */
    public void configInterceptor(Interceptors me) {
//        me.add(new LoginInterceptor());
    }
    
    /**
     * global handler ,name "contextPath" can be global project relative path root directory in js,html
     */
    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler("contextPath"));
    }
    
    public static void main(String[] args) {
        /**
         * 特别注意：IDEA 之下建议的启动方式，仅比 eclipse 之下少了最后一个参数
         * JFinal 3.2版本的启动方式
         */
//        JFinal.start("src/main/webapp", 80, "/");
        /**
         * JFinal 3.6版本启动方式
         */
        UndertowServer.start(MyJFinalConfig.class, 80, true);
    }
    
    /**
     * this method can be used after start up server,such as start a timing task
     */
    @Override
    public void onStart()
    {
       
    }
    
    /**
     * this method can be used befor shutDown server,such as save some data to db
     */
    @Override
    public void onStop()
    {
        
    }
}