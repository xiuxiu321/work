package com.baizhi.controller;


import com.baizhi.entity.Boss;
import com.baizhi.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/boss")
public class BossController {
    @Autowired
    private BossService bossService;

    @RequestMapping("/login")
    public String login(String name, String pwd, HttpSession session) {
        Boss boss = bossService.find(name, pwd);
        if (boss != null) {
            //登录的时候保存哪个管理员
            session.setAttribute("boss", name);
            return "redirect:/department//findAll";
        } else {

            return "login";
        }
    }

    @RequestMapping("/insert")
    public String insert(String username, String name, String pwd, String sex) {
        if (sex.equals("m")) {
            sex = "男";
        } else {
            sex = "女";
        }
        Boss boss = new Boss(null, username, name, pwd, sex);
        bossService.save(boss);
        return "login";
    }

}
