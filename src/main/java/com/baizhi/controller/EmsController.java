package com.baizhi.controller;


import com.baizhi.aspect.Log;
import com.baizhi.entity.Department;
import com.baizhi.entity.Emp;
import com.baizhi.service.DepartmentService;
import com.baizhi.service.EmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("ems")
public class EmsController {
    @Autowired
    private EmsService emsService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("findAll")
    public String findAll(Integer id, HttpServletRequest request) {//根据部门id查找所属员工
        List<Emp> emps = emsService.findAll(id);
        request.setAttribute("emps", emps);
        return "forward:/emplist.jsp";
    }


    //添加员工之前查找所有部门
    @RequestMapping("findDeps")
    public String findDep(HttpServletRequest request) {
        List<Department> all = departmentService.findAll();
        request.setAttribute("deps", all);
        return "forward:/addEmp.jsp";
    }

    @Log(name = "删除员工")
    //删除员工
    @RequestMapping("delete")
    public String delete(Emp emp, HttpServletRequest request) {
        emsService.delete(emp.getId());
        List<Emp> all = emsService.findAll(emp.getDepartmentId());
        request.setAttribute("emps", all);
        return "forward:/emplist.jsp";
    }

    @Log(name = "添加员工")
    @RequestMapping("add")
    public String add(MultipartFile upload, String name, double salary, Integer age, Integer departId, HttpServletRequest request) throws IOException {//添加员工
        Emp emp = new Emp();
        //获取保存文件的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/img");
        //获取文件名
        String originalFilename = upload.getOriginalFilename();
        upload.transferTo(new File(realPath + "/" + originalFilename));

        emp.setName(name).setSalary(salary).setAge(age).setDepartmentId(departId).setSrc(originalFilename);
        emsService.save(emp);
        List<Emp> emps = emsService.findAll(departId);
        request.setAttribute("emps", emps);
        return "forward:/emplist.jsp";

    }

    @RequestMapping("before")
    public String findOne(Integer id, HttpServletRequest request) {
        Emp emp = emsService.findOne(id);
        List<Department> all = departmentService.findAll();
        request.setAttribute("deps", all);
        request.setAttribute("emp", emp);
        return "forward:/updateEmp.jsp";
    }


    /*@RequestMapping("update")
    public String update(Emp emp,MultipartFile upload,HttpServletRequest request) throws IOException {
        if(upload!=null){//修改图片的时候
            String realPath = request.getSession().getServletContext().getRealPath("/img");
            //获取文件名
            String originalFilename = upload.getOriginalFilename();
            upload.transferTo(new File(realPath + "/" + originalFilename));
            emp.setSrc(originalFilename);
            emsService.update(emp);
            List<Emp> all = emsService.findAll(emp.getDepartmentId());
            request.setAttribute("emps",all);

        }else if(upload==null){//没有修改图片的时候
            Emp one = emsService.findOne(emp.getId());
            emp.setSrc(one.getSrc());
            emsService.update(emp);
            List<Emp> all = emsService.findAll(emp.getDepartmentId());
            request.setAttribute("emps",all);

        }
        return "forward:/emplist.jsp";
    }*/
    /*@RequestMapping("update")
    public String update(Emp emp,MultipartFile upload,HttpServletRequest request) throws IOException {
        if(upload!=null){//修改图片的时候
            String realPath = request.getSession().getServletContext().getRealPath("/img");
            //获取文件名
            String originalFilename = upload.getOriginalFilename();
            //String src = emp.getSrc();
            Emp one = emsService.findOne(emp.getId());
            if(originalFilename.equals(one.getSrc())){//没有修改图片的时候
                emsService.update(emp);
            }else{
                upload.transferTo(new File(realPath + "/" + originalFilename));
                emp.setSrc(originalFilename);
                emsService.update(emp);
                List<Emp> all = emsService.findAll(emp.getDepartmentId());
                request.setAttribute("emps",all);
            }



        }else if(upload==null){//没有修改图片的时候
            Emp one = emsService.findOne(emp.getId());
            emp.setSrc(one.getSrc());
            emsService.update(emp);
            List<Emp> all = emsService.findAll(emp.getDepartmentId());
            request.setAttribute("emps",all);

        }
        return "forward:/emplist.jsp";
    }*/

    @Log(name = "修改员工")
    @RequestMapping("update")
    public String update(Emp emp, MultipartFile upload, HttpServletRequest request) throws IOException {
        if (upload != null) {//修改图片的时候
            String realPath = request.getSession().getServletContext().getRealPath("/img");
            String originalFilename = upload.getOriginalFilename();//获取文件名
            int length = originalFilename.length();
            Emp one = emsService.findOne(emp.getId());
            //当one.getSrc()为null的时候 并且 也没有上传图片 也放在这里
            if ((one.getSrc().equals(originalFilename) || length == 0) || (one.getSrc() == null && length == 0)) {//没有修改图片的时候
                System.out.println("没修改");
                emp.setSrc(one.getSrc());
                emsService.update(emp);
                List<Emp> all = emsService.findAll(emp.getDepartmentId());
                request.setAttribute("emps", all);

            } else {//修改图片的时候
                upload.transferTo(new File(realPath + "/" + originalFilename));
                emp.setSrc(originalFilename);
                emsService.update(emp);
                List<Emp> all = emsService.findAll(emp.getDepartmentId());
                request.setAttribute("emps", all);
                System.out.println("修改");
            }
           /* System.out.println(originalFilename);
            System.out.println(length);
            System.out.println("**********");
            System.out.println(one.getSrc());*/
        }
        return "forward:/emplist.jsp";
    }

}
