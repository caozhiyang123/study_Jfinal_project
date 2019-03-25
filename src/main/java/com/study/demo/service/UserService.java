package com.study.demo.service;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
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

    public boolean save(User user)
    {
        Record record = new Record().set("name", user.getName()).set("pass",user.getPass())
                .set("facebookId", user.getFacebookId()).set("coins", user.getCoins());
        return Db.save("user", record);
      
      /*return Db.tx(new IAtom(){
          public boolean run() throws SQLException {
             int count = Db.update("update account set cash = cash - ? where id = ?", 100, 123);
             int count2 = Db.update("update account set cash = cash + ? where id = ?", 100, 456);
             return count == 1 && count2 == 1;
          }});
      */
    }
    
    // 分页查询年龄大于18的user,当前页号为1,每页10个user
    public Page<User> pageQuery(int pageNum,int pageSize){
        return User.dao.paginate(pageNum, pageSize, "SELECT * ", "FROM user  where id >?",0);
    }

}
