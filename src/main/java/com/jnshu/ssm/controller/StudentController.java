package com.jnshu.ssm.controller;
import com.jnshu.ssm.pojo.Page;
import com.jnshu.ssm.pojo.Student;
import com.jnshu.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;


/**
 * author : baiyunzhong
 * created time : 2019/7/22
 */
@Controller
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService studentService;
    private static final Logger LOGGER =Logger.getLogger("StudentController");
    /*测试*/
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "index";
    }
    /*通过id获得学生信息*/
    @RequestMapping(value ="/GET/student",method = RequestMethod.GET)
    public ModelAndView testSSM(ModelAndView mv , @RequestParam String onlineId){
        Student student = studentService.findByOnlineId(onlineId);
        mv.addObject("student",student);
        mv.setViewName("index");
        LOGGER.info("参数："+onlineId+"/t"+"返回值"+student);
        return mv;
    }
    /*获得全部学生信息*/
    @RequestMapping(value ="/GET/students")
    public ModelAndView getAllStudent(ModelAndView mv ){
        List<Student> students = studentService.findAll();
        mv.addObject("students",students);
        mv.setViewName("index");
        return mv;
    }
    /*获得保存学生信息*/
    @RequestMapping(value ="/POST/student")
    public ModelAndView saveStudent(ModelAndView mv ,Student student){
        //设置创立时间
        student.setCreateAt(System.currentTimeMillis());
        //把数据保存
        Integer row = studentService.addOne(student);
        if(row>=0){
            mv.addObject("postMsg","保存成功");
            LOGGER.info("信息保存成功！");
        } else {
            mv.addObject("postMsg","保存失败");
            LOGGER.info("信息保存失败！信息为："+student);
        }
        mv.setViewName("index");
        return mv;
    }
    /*获得修改学生信息*/
    @RequestMapping(value ="/UPDATE/student")
    public ModelAndView updateStudent(ModelAndView mv ,Student student){
        boolean flag = studentService.updateOne(student);
        if(flag){
            mv.addObject("updateMsg","修改成功");
            LOGGER.info("信息修改成功！");
        } else {
            mv.addObject("updateMsg","修改失败");
            LOGGER.info("信息修改失败！信息为："+student);
        }
        mv.setViewName("index");
        return mv;
    }
    /*删除学生信息*/
    @RequestMapping(value ="/DELETE/student")
    public ModelAndView deleteStudent(ModelAndView mv ,@RequestParam String onlineId){
        boolean flag = studentService.deleteOne(onlineId);
        if(flag){
            mv.addObject("deleteMsg","删除成功");
            LOGGER.info("信息保存成功！");
        } else {
            mv.addObject("deleteMsg","删除失败");
            LOGGER.info("信息保存失败");
        }
        mv.setViewName("index");
        return mv;
    }
    /*获得本页的学生信息
    * 先查询学生数据总数
    * 从前端拿到 currentPage当前页数
    * 直接显示本页数据*/
    @RequestMapping(value ="/GET/students/page",method=RequestMethod.GET)
    public ModelAndView getAllStudent(@RequestParam(required = false,defaultValue = "1") Integer currentPage,ModelAndView mv ){
        Page page = new Page();
        //查询数据总条数
        Integer totalCount = studentService.totalCount();
        page.setTotalCount(totalCount);
        //计算总页数    ceil向上取整
        int pageCount = (int) Math.ceil(totalCount/10);
        page.setPageCount(pageCount);
        //对当前页数做判断
        if(currentPage<=0){
            page.setCurrentPage(1);
        }else if (currentPage>pageCount){
            page.setCurrentPage(pageCount);
        } else {
            page.setCurrentPage(currentPage);
        }
        //每页显示10行
        page.setCount(10);
        //从第start+1行开始显示
        int start = (page.getCurrentPage()-1)*page.getCount() ;
        page.setStart(start);
        List<Student> students = studentService.findByPage(page);
        mv.addObject("students",students);
        mv.addObject("page",page);
        mv.setViewName("page");
        return mv;
    }
}
