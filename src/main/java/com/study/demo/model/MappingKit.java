package com.study.demo.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.study.demo.vo.User;

public class MappingKit
{
    public static void mapping(ActiveRecordPlugin arp) {
        arp.addMapping("user", "id", User.class);
    }

}
