package com.baizhi.service;

import com.baizhi.dao.EmsDao;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmsServiceImpl implements EmsService {
    @Autowired
    private EmsDao emsDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Emp> findAll(Integer id) {
        return emsDao.findAll(id);
    }

    @Override
    public void delete(Integer id) {
        emsDao.delete(id);
    }

    @Override
    public void update(Emp emp) {
        emsDao.update(emp);
    }

    @Override
    public void save(Emp emp) {
        emsDao.save(emp);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Emp findOne(Integer id) {

        return emsDao.findOne(id);
    }
}
