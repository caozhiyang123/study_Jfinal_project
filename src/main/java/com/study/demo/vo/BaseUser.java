package com.study.demo.vo;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean
{
    public void setId(java.lang.Long id) {  set("id", id); }
    public java.lang.Long getId() {  return getLong("id");}

    public void setName(java.lang.String name) { set("name", name);}
    public java.lang.String getName() {  return getStr("name");}
    
    public void setPass(java.lang.String pass) { set("pass", pass);}
    public java.lang.String getPass() {  return getStr("pass");}
    
    public long getFacebookId(){ return getLong("facebookId");}
    public void setFacebookId(java.lang.Long facebookId){ set("facebookId",facebookId);}
    
    public long getCoins(){ return getLong("coins");}
    public void setCoins(long coins){  set("coins",coins);}
}
