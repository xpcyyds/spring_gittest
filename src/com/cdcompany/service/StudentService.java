package com.cdcompany.service;

import com.cdcompany.dao.StudentDao;
import com.cdcompany.entity.Student;

import java.util.ArrayList;

public class StudentService {
    /**
     * new 学生对象dao层
     */
    private StudentDao studentDao = new StudentDao();

    /**
     * 查询所有的学生信息
     *
     * @return
     */
    public ArrayList<Student> allStudent() {
        // 在通过业务逻辑层调用dao层代码
        ArrayList<Student> studententities = studentDao.selectAll();
        return studententities;
    }

    /**
     * 2.通过Id查询学生信息
     *
     * @return
     */
    public Student getById(Integer id){
        Student student = studentDao.getById(id);
        return student;
    }

    /**
     * 3.插入学生信息
     *
     * @param student
     */
    public void insertStu(Student student){
        studentDao.insertStu(student);
    }

    /**
     * 4.通过学生id更改学生信息
     *
     * @param student
     */
    public Integer updateStu(Student student){
        Integer len = studentDao.updateStu(student);
        return len;
    }

    /**
     * 5.根据主键id删除学生信息
     * @param id
     */
    public Integer deleteStu(Integer id){
        Integer len = studentDao.deleteStu(id);
        return len;
    }
}
