package com.baizhi.dao;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentDao {
    //查询所有部门
    public List<Department> findAll();

    //添加部门
    public void save(Department department);

    //更新部门
    public void update(Department department);


}
