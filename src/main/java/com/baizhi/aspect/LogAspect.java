package com.baizhi.aspect;


import com.baizhi.entity.Dairy;
import com.baizhi.service.DairyService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//代表当前类为切面类（切点+通知）
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Autowired
    private HttpSession session;//自动注入一个session
    @Autowired
    private DairyService dairyService;

    /*
     * 谁 时间 事情 结果
     *
     * */
    //代表是什么通知
    @Around("pt()")
    public Object testAround(ProceedingJoinPoint proceedingJoinPoint) throws ParseException {
        //log.info("前");
        String name = (String) session.getAttribute("boss");//谁
        Date date = new Date();//时间

        //什么事情
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Log annotation = method.getAnnotation(Log.class);
        String message = annotation.name();

        boolean flag = false;
        //log.info("管理员的名字是{}",name);
        Object proceed = null;
        try {
            //放行
            proceed = proceedingJoinPoint.proceed();//目标方法执行的返回值
            flag = true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(date);
        Date parse = simpleDateFormat.parse(format);
        //log.info("后");
        Dairy dairy = new Dairy(null, name, parse, flag, message);
        dairyService.save(dairy);
        return proceed;
    }

    @Pointcut("@annotation(com.baizhi.aspect.Log)")//基于哪个切
    public void pt() {

    }
}
