package com.baizhi.service;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentService {
    public void save(Department department);

    public List<Department> findAll();

    //更新
    public void update(Department department);
}
