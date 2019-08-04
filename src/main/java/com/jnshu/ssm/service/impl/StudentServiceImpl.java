package com.jnshu.ssm.service.impl;

import com.jnshu.ssm.dao.StudentMapper;
import com.jnshu.ssm.pojo.Page;
import com.jnshu.ssm.pojo.Student;
import com.jnshu.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : baiyunzhong
 * created time : 2019/7/22
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    /* private static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dao.xml");
     private static StudentMapper studentMapper = ctx.getBean(StudentMapper.class);*/
    public List<Student> findAll() {
        List<Student> students = studentMapper.findAll();
        return students;
    }
    public List<Student> findByName(String name) {
        String name1 = name+"%";
        List<Student> students = studentMapper.findByName(name1);
        return students;
    }

    public Student findByOnlineId(String onlineId) {
        Student student = studentMapper.findByOnlineId(onlineId);
        return student;
    }

    public Integer addOne(Student student) {
        studentMapper.add(student);
        return student.getID();
    }

    public boolean deleteOne(String onlineId) {
        return studentMapper.deleteByOnlineId(onlineId);
    }

    public boolean updateOne(Student student) {
        return studentMapper.updateByOnlineId(student);
    }

    @Override
    public List<Student> findByPage(Page page) {
        return studentMapper.findByPage(page);
    }

    @Override
    public Integer totalCount() {
        return studentMapper.findCount();
    }
}
