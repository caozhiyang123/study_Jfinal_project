package com.study.demo.interceptor;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
//        HttpSession session = httpSessionEvent.getSession();
//        User user = (User) session.getAttribute("user");
//        LoginUtils.LOGIN_USERS.remove(user.getId());
        System.out.println("登录失效了");
    }
}
