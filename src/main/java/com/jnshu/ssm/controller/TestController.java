package com.jnshu.ssm.controller;

import com.jnshu.ssm.pojo.Student;
import com.jnshu.ssm.service.StudentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * author : baiyunzhong
 * created time : 2019/8/3
 */
@Controller
@RequestMapping(value = "/test",produces = {"application/json;charset=utf-8"})
public class TestController {
    public static final Logger LOGGER = Logger.getLogger("TestController");
    @Autowired
    private StudentService studentService;
    /*JSON*/
    @RequestMapping("/getStudent1.do")
    @ResponseBody
    public JSONObject getStudent(){
        JSONObject object =new JSONObject();
        String name = "李白";
        String age = "2000";
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("age",age);
        object.put("singer",map);
        LOGGER.info("得到的参数map:"+map);
        LOGGER.info("得到的参数object:"+object);
        return object;
    }
    /*JSON*/
    @RequestMapping("/getStudent2.do")
    @ResponseBody
    public JSONObject getStudent2(){
        JSONObject object =new JSONObject();
        Student student =studentService.findByOnlineId("333");
        object.put("student",student);
        LOGGER.info("得到的参数student:"+student);
        LOGGER.info("得到的参数object:"+object);
        return object;
    }
    /*JSON*/
    @RequestMapping("/getStudents.do")
    @ResponseBody
    public List<Student> getStudents(){
        List<Student> students =studentService.findAll();
        LOGGER.info("得到的参数students:"+students);
        return students;
    }
    /*JSON*/
    @RequestMapping(value ="/astudent",method = RequestMethod.GET)
    public String getAStudent(){
        Student student =studentService.findByOnlineId("11");
        LOGGER.info("得到的参数student:"+student);
        return "taglib";
    }

    /*测试校验*/
    @RequestMapping(value ="/POST/student",method = RequestMethod.GET)
    public ModelAndView saveStudent( ModelAndView mv,@Valid Student student,BindingResult result) {
        if(result.hasErrors()){
            mv.setViewName("error");
            LOGGER.info("输入参数不合规范"+result.getFieldError().getDefaultMessage());
            LOGGER.info("输入参数不合规范"+result.getFieldError());
        } else {
            mv.addObject("student",student);
            mv.setViewName("index");
        }
        return mv;

    }
    /*测试校验*/
    @RequestMapping("/getStudent.do")
    @ResponseBody
    public Student getStudent(@Valid Student student,BindingResult result){
        if(result.hasErrors()){
            LOGGER.info("输入参数不合规范"+result.getFieldError());
        } else {
            LOGGER.info("得到的参数student:"+student);

        }
        return student;
    }


}
