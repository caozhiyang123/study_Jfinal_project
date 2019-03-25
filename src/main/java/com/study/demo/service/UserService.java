package com.study.demo.service;

import java.util.List;

import com.study.demo.model.User;


public class UserService extends BaseService
{
    public static final ThreadLocal<UserService> service = new ThreadLocal<UserService>(){
      @Override
      protected UserService initialValue() {
          return new UserService();
      }
    };
    
    public User login(User user)
    {
        return user.findFirst("select * from user where name = ? and pass = ?", user.getName(),user.getPass());
    }
    
    public List<User> findAll()
    {
        return User.dao.findAll();
    }

}
