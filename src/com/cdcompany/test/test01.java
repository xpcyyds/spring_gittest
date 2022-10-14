package com.cdcompany.test;

import com.cdcompany.entity.Student;
import com.cdcompany.entity.User;
import com.cdcompany.service.StudentService;
import com.cdcompany.service.UserService;

import java.sql.*;
import java.util.ArrayList;

public class test01 {
    public static void main(String[] args){
        StudentService studentService =new StudentService();
        UserService userService = new UserService();
        /*1.
        ArrayList<Student> studentEntity = studentService.allStudent();
        for (Student stu:studentEntity) {
            System.out.println(stu);
        }*/

        /*2.
        Student student = studentService.getById(2);
        System.out.println(student);*/

       /* 3.
       Student stu = new Student(null,"xpc",10,"大悟");
        studentService.insertStu(stu);*/

        /*4.Student stu = new Student(1,"you",20,"hubei");
        studentService.updateStu(stu);
        System.out.println(stu);*/


        /*Integer len = studentService.deleteStu(11);
        System.out.println(len);*/

        /*User user = new User("13789977656","111111");
        if(userService.registerUser(user)){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        };*/

        User user = new User("13789977656","11");
        if(userService.loginUser(user)){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        };

    }
}
