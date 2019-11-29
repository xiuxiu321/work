package com.baizhi.dao;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmsDao {
    //根据部门id查询该部门下所有员工
    public List<Emp> findAll(Integer id);

    //根据 员工id 删除员工
    public void delete(Integer id);

    //修改员工信息
    public void update(Emp emp);

    //添加员工
    public void save(Emp emp);

    //根据id 查找单个员工
    public Emp findOne(Integer id);
}
