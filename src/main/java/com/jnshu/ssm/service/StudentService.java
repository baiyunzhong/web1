package com.jnshu.ssm.service;

import com.jnshu.ssm.pojo.Page;
import com.jnshu.ssm.pojo.Student;

import java.util.List;

/**
 * author : baiyunzhong
 * created time : 2019/7/22
 */
public interface StudentService {
    /*查询*/
    //查询所有学生信息
    public List<Student> findAll();
    //根据名字 模糊查询
    public List<Student> findByName(String name);
    //根据学号 精确查询
    public Student findByOnlineId(String onlineId);
    /*增加*/
    //增加一条数据
    public Integer addOne(Student student);
    /*删除*/
    //删除根据学号数据
    public boolean deleteOne(String onlineId);
    /*修改*/
    //修改一套数据
    public boolean updateOne(Student student);
    //获得数据总数
    public Integer totalCount();
    //根据页数查询信息
    public List<Student> findByPage(Page page);

}
