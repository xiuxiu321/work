package com.baizhi.controller;

import com.baizhi.aspect.Log;
import com.baizhi.entity.Dairy;
import com.baizhi.entity.Department;
import com.baizhi.service.DairyService;
import com.baizhi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class Atest {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DairyService dairyService;


    @Log(name = "这是查找全部")
    @RequestMapping("/findAll")
    @ResponseBody()
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @Log(name = "这是查找全部日志")
    @RequestMapping("/find")
    @ResponseBody()
    public List<Dairy> find() {
        return dairyService.findAll();
    }
}
