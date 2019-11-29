package com.baizhi.controller;


import com.baizhi.aspect.Log;
import com.baizhi.entity.Department;
import com.baizhi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request) {//查询所有部门
        List<Department> all = departmentService.findAll();
        request.setAttribute("deps", all);
        return "departments";
    }

    @Log(name = "更新部门信息")
    @RequestMapping("/update")
    public String update(Integer id, Integer num, String dname) {//更新部门
        Department department = new Department();
        department.setId(id).setName(dname).setNum(num);
        departmentService.update(department);
        return "redirect:/department/findAll";
    }

    @Log(name = "插入部门")
    @RequestMapping("insert")
    public String insert(Integer num, String dname) {//添加部门
        Department department = new Department();
        department.setNum(num).setName(dname);
        departmentService.save(department);
        return "redirect:/department/findAll";
    }

}
