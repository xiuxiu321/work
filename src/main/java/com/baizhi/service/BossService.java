package com.baizhi.service;

import com.baizhi.entity.Boss;

public interface BossService {
    //登录
    public Boss find(String username, String password);

    //注册
    public void save(Boss boss);


}
