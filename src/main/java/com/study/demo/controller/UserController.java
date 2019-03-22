package com.study.demo.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.json.FastJson;
import com.study.demo.vo.User;

@SuppressWarnings("all")
public class UserController extends Controller
{
    public void queryById(){
        long id =  Long.parseLong(getPara(0, "243972853"));
        User user = User.dao.findFirst("select * from user where id =?", id);
        renderJson(user == null?"user not exit error":user.toString());
    }
    
    public void list(){
        List<User> users = User.dao.findAll();
        renderJson(users.toString());
    }
    
    public void save(){
       User user = getModel(User.class);
       boolean flag = user.save();
       renderJson(flag?"success":"fail");
    }
    
    
    public void login(){
//        User user = getModel(User.class);
        User user = getBean(User.class);
        user = user.findFirst("select * from user where name = ? and pass = ?", user.getName(),user.getPass());
        if(user !=null && user.getId() != null){
            setSessionAttr("user", user);
//            render(getAttr("url")!=null?getAttr("url").toString():"/index.html");
            redirect(getAttr("url")!=null?getAttr("url").toString():"/index.html");
        }else{
            renderHtml("<script>alert('login failed');location.href='/view/login.html'</script>");
        }
    }
}
