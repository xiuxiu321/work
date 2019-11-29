package com.baizhi.dao;

import com.baizhi.entity.Boss;
import org.apache.ibatis.annotations.Param;

public interface BossDao {
    //登录
    public Boss find(@Param("username") String username, @Param("password") String password);

    //注册
    public void save(Boss boss);
}
