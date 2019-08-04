package com.jnshu.ssm.controller;

import com.jnshu.ssm.pojo.Student;
import com.jnshu.ssm.service.StudentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("/getStudents.do")
    @ResponseBody
    public List<Student> getStudents(){
        List<Student> students =studentService.findAll();
        LOGGER.info("得到的参数students:"+students);
        return students;
    }
}
