package com.study.demo.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSysConfig<M extends BaseSysConfig<M>> extends Model<M> implements IBean {

	public void setVariable(java.lang.String variable) {
		set("variable", variable);
	}
	
	public java.lang.String getVariable() {
		return getStr("variable");
	}

	public void setValue(java.lang.String value) {
		set("value", value);
	}
	
	public java.lang.String getValue() {
		return getStr("value");
	}

	public void setSetTime(java.util.Date setTime) {
		set("set_time", setTime);
	}
	
	public java.util.Date getSetTime() {
		return get("set_time");
	}

	public void setSetBy(java.lang.String setBy) {
		set("set_by", setBy);
	}
	
	public java.lang.String getSetBy() {
		return getStr("set_by");
	}

}
