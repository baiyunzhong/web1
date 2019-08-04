package com.jnshu.ssm.dao;

import com.jnshu.ssm.pojo.Page;
import com.jnshu.ssm.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author : baiyunzhong
 * created time : 2019/7/22
 */
@Repository
public interface StudentMapper {
    /*查询所有信息*/
    public List<Student> findAll();
    /*通过id查询所有信息*/
    public Student findById(Integer id);
    /*通过名字查询所有信息*/
    public List<Student>findByName(String name);
    /*通过学号查询信息*/
    public Student findByOnlineId(String onlineId);
    /*新增信息*/
    public void add (Student student);
    /*修改信息*/
    public boolean update(Student student);
    public boolean updateByOnlineId(Student student);
    /*删除信息*/
    public boolean delete(Integer id);
    /*删除信息*/
    public boolean deleteByOnlineId(String onlineId);
    /*分页查看学生信息*/
    public List<Student> findByPage(Page page);
    /*查看学生综述*/
    public Integer findCount();
}
