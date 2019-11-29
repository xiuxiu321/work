package com.baizhi.service;

import com.baizhi.dao.BossDao;
import com.baizhi.entity.Boss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BossServiceImpl implements BossService {
    @Autowired
    private BossDao bossDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Boss find(String username, String password) {
        return bossDao.find(username, password);
    }

    @Override
    public void save(Boss boss) {
        bossDao.save(boss);
    }
}
