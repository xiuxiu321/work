package com.baizhi.service;

import com.baizhi.dao.DepartmentDao;
import com.baizhi.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Department> findAll() {

        return departmentDao.findAll();
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }
}
