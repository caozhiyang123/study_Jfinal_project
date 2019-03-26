package com.study.demo.controller;

import java.util.List;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.json.FastJson;
import com.jfinal.plugin.activerecord.Page;
import com.mysql.jdbc.StringUtils;
import com.study.demo.io.PageContent;
import com.study.demo.model.User;
import com.study.demo.service.BaseService;
import com.study.demo.service.UserService;

@SuppressWarnings("all")
public class UserController extends Controller
{
    private UserService service = UserService.service.get();
    
    public void queryById(){
        long id =  Long.parseLong(getPara(0, "243972853"));
        User user = User.dao.findFirst("select * from user where id =?", id);
        renderJson(user == null?"user not exit error":user.toString());
    }
    
    public void list(){
        List<User> users = service.findAll();
        renderJson(users.toString());
    }
    
    public void save(){
       User user = getModel(User.class);
       boolean flag = service.save(user);
       renderJson(flag?"success":"fail");
    }
    
    
    public void login(){
        Object url = getSessionAttr("url");
        setSessionAttr("url", "");
        User user = getBean(User.class);//        User user = getModel(User.class);
        user = service.login(user);
        if(user !=null && user.getId() != null){
            setSessionAttr("user", user);
            redirect((url!=null && !StringUtils.isNullOrEmpty(url.toString()))?url.toString():"/index.html");//请求重定向 //            render(getAttr("url")!=null?getAttr("url").toString():"/index.html");//请求转发
        }else{
            renderHtml("<script>alert('login failed');location.href='/view/login.html'</script>");
        }
    }
    
    public  void pageQuery(){
        Page<User> users = service.pageQuery(Integer.parseInt(get("pageNum")), Integer.parseInt(get("pageSize")));
        int page_count = users.getTotalPage();
        List<User> page_content = users.getList();
        PageContent pageContent = new PageContent();
        pageContent.setPageCount(page_count);
        pageContent.setPageContent(page_content);
        renderJson(FastJson.getJson().toJson(pageContent));
    }
}
