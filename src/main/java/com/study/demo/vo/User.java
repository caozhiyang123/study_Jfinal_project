package com.study.demo.vo;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

public class User<M extends User<M>> extends Model<M> implements IBean
{
   private static final long serialVersionUID = 1L;
   
   private long id;
   private String name;
   private long facebookId;
   private long coins;
   
    public User(long id, String name, long facebookId, long coins)
    {
        super();
        this.id = id;
        this.name = name;
        this.facebookId = facebookId;
        this.coins = coins;
    }
    public long getId(){ return id;}
    public void setId(long id){ this.id = id;}
    public String getName(){ return name;}
    public void setName(String name){    this.name = name;}
    public long getFacebookId(){    return facebookId;}
    public void setFacebookId(long facebookId){    this.facebookId = facebookId;}
    public long getCoins(){    return coins;}
    public void setCoins(long coins){    this.coins = coins;}
   
}
