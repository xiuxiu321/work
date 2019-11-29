package com.baizhi.service;

import com.baizhi.dao.DairyDao;
import com.baizhi.entity.Dairy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DairyServiceImpl implements DairyService {

    @Autowired
    private DairyDao dairyDao;


    @Override
    public void save(Dairy dairy) {
        dairyDao.save(dairy);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Dairy> findAll() {

        return dairyDao.findAll();
    }
}
