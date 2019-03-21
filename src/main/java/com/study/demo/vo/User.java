package com.study.demo.vo;

import java.io.Serializable;

public class User extends BaseUser<User> implements Serializable
{
    private static final long serialVersionUID = 1L;
    public static final User dao = new User().dao();
}
