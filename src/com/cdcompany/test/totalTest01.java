package com.cdcompany.test;

import com.cdcompany.entity.Student;
import com.cdcompany.entity.User;
import com.cdcompany.service.StudentService;
import com.cdcompany.service.UserService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class totalTest01 {
    private static StudentService studentService = new StudentService();
    private static UserService userService = new UserService();
    public static void main(String[] args) {
        loginMenu();
    }

    /**
     * 1.登录或注册页面
     */
    public static void loginMenu(){
        System.out.println("欢迎来到我们每特教育蚂蚁课堂登录系统");
        System.out.println("1.注册用户");
        System.out.println("2.登录用户");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        switch (result){
            case 1:
                registerUser();
                break;

            case 2:
                loginUser();
                break;
        }
    }

    public static void registerUser(){
        System.out.println("请输入用户的手机号码");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.next();

        System.out.println("请输入用户的密码");
        Scanner scanner1 = new Scanner(System.in);
        String pwd = scanner1.next();

        User user = new User(phone,pwd);
        if(userService.registerUser(user)){
            System.out.println("注册成功，重新登录");
            loginMenu();
        }else {
            System.out.println("注册失败，用户已存在，请重新输入");
            registerUser();
        }
    }


    public static void loginUser(){
        System.out.println("请输入手机号码");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.next();

        System.out.println("请输入用户的密码");
        Scanner scanner1 = new Scanner(System.in);
        String pwd = scanner1.next();

        User user = new User(phone,pwd);
        if(userService.loginUser(user)){
            System.out.println("登录成功");
            mainMenu();
        }else {
            System.out.println("登录失败，请重新输入");
            loginUser();
        }
    }
    //1.菜单页面
    public static void mainMenu() {
        while (true) {
            // 1.提示语
            System.out.println("欢迎来到我们每特教育蚂蚁课堂学生管理系统");
            System.out.println("1.查询所有的学生信息");
            System.out.println("2.根据学生id查询学生信息");
            System.out.println("3.新增学生信息");
            System.out.println("4.根据学生id修改学生信息");
            System.out.println("5.根据学生id删除学生信息");
            System.out.println("6.退出系统");
            System.out.println("请选择对应序号:");
            // 2.接受用户输入的序号 int
            Scanner scanner = new Scanner(System.in);
            ArrayList<String> str = new ArrayList<>();
            str.add("1");
            str.add("2");
            str.add("3");
            str.add("4");
            str.add("5");
            str.add("6");
            int result = scanner.nextInt();

            /*for (String s:str) {
                if(result == s){
                    break;
                }else {
                    defaultInfor();
                }
            }*/

            // 3.在根据用户选择的序号 判断
            switch (result) {
                case 1:
                    showAllStudent();
                    break;//直接让我们while退出了
                case 2:
                    findByIdStudent();
                    break;
                case 3:
                    insertStudent();
                    break;
                case 4:
                    updateIdStudent();
                    break;
                case 5:
                    delIdStudent();
                    break;
                case 6:
                    loginMenu();
                    break;
                default:
                    defaultInfor();
                    break;
            }
        }
    }

    /**
     * 查询所有学生信息
     */
    public static void showAllStudent() {
        System.out.println("查询到的所有学生信息");
        ArrayList<Student> studentEntities = studentService.allStudent();
        for (Student stu : studentEntities) {
            System.out.println(stu);
        }
    }

    public static void findByIdStudent(){
        // 2.接受用户输入的序号 int
        System.out.println("请输入需要查询学生的ID");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        Student stu = studentService.getById(id);
        if(stu == null){
            System.out.println("本系统暂无该学生信息");
        }else{
            System.out.println("通过ID查到学生的信息:");
            System.out.println(stu);
        }
    }

    public static void insertStudent(){
        // 2.接受用户插入的信息
        System.out.println("请输入需要插入用户的姓名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.println("请输入需要插入用户的年龄");
        Scanner scanner1 = new Scanner(System.in);
        Integer age = scanner1.nextInt();

        System.out.println("请输入需要插入用户的地址");
        Scanner scanner2 = new Scanner(System.in);
        String address = scanner2.next();

        Student stu = new Student(null,name,age,address);
        studentService.insertStu(stu);
        System.out.println("学生信息插入成功");
    }

    public static void updateIdStudent(){
        System.out.println("请输入需要修改对应学生信息的ID");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        if(studentService.getById(id) == null){
            System.out.println("本系统没有该ID对应的学生信息，请重新输入");
            updateIdStudent();
        }else {
            System.out.println("请输入需要修改的学生姓名");
            Scanner scanner1 = new Scanner(System.in);
            String name = scanner1.next();

            System.out.println("请输入需要修改对应学生信息的年龄");
            Scanner scanner3 = new Scanner(System.in);
            Integer age = scanner3.nextInt();

            System.out.println("请输入需要修改对应学生信息的地址");
            Scanner scanner4 = new Scanner(System.in);
            String address= scanner4.next();

            Student stu = new Student(id,name,age,address);
            studentService.updateStu(stu);
        }
    }

    public static void delIdStudent(){
        System.out.println("请输入需要删除对应学生的ID");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        if(studentService.getById(id) == null){
            System.out.println("没有该ID对应的学生信息，删除失败");
            delIdStudent();
        }else {
            studentService.deleteStu(id);
            System.out.println("删除成功");
        }
    }

    public static void defaultInfor(){
        System.out.println("输入无效，请重新输入");
        mainMenu();
    }

}
