package com.cdcompany.dao;

import com.cdcompany.entity.Student;
import com.cdcompany.utils.StudentJdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDao{

    /**
     * 1.查询所有学生信息
     * @return
     */
    public ArrayList<Student> selectAll(){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            connection = StudentJdbcUtils.getConnection();
            // 4.获取执行者对象
            statement = connection.createStatement();
            // 5.执行sql语句获取返回结果
            resultSet = statement.executeQuery("select * from student");
            ArrayList<Student> studentEntities = new ArrayList<>();
            // 6.对返回结果进行处理
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                Student student = new Student(id,name,age,address);
                studentEntities.add(student);
            }
            return studentEntities;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            // 7.释放资源
            StudentJdbcUtils.closeConnection(resultSet,statement,connection);

        }

    }

    /**
     * 2.根据id查询学生信息
     * @param stu_id
     * @return
     */
    public Student getById(Integer stu_id){
        if(stu_id == null){
            return null;
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            /*Class.forName("com.mysql.cj.jdbc.Driver");
            // 3.获取执行者
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/school?serverTimezone=UTC",
                    "root", "111111");*/
            connection = StudentJdbcUtils.getConnection();
            // 4.获取执行者对象
            statement = connection.createStatement();
            // 5.执行sql语句获取返回结果
            resultSet = statement.executeQuery("select * from student where id = "+ stu_id);
            // 6.对返回结果进行处理

            if(!resultSet.next()){
                return null;
            }
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Integer age = resultSet.getInt("age");
            String address = resultSet.getString("address");
            Student student = new Student(id,name,age,address);
            return student;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            // 7.释放资源
            /*try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            StudentJdbcUtils.closeConnection(resultSet,statement,connection);

        }
    }

    /**
     * 3.新增学生信息
     *
     * @param student
     */
    public Integer insertStu(Student student){
        Connection connection = null;
        Statement statement = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            connection = StudentJdbcUtils.getConnection();
            // 4.获取执行者对象
            statement = connection.createStatement();
            // 5.执行sql语句获取返回结果
            Integer len =statement.executeUpdate("insert into student (`id`, `name`, `age`, `address`)" +
                    " VALUES (null,'"+student.getName()+"','"+student.getAge()+"','"+student.getAddress()+"')");
            // 6.对返回结果进行处理
            return len;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            // 7.释放资源
            StudentJdbcUtils.closeConnection(statement,connection);
        }
    }

    /**
     * 4.更新学生信息
     * @param student
     */
    public Integer updateStu(Student student){
        Connection connection = null;
        Statement statement = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            connection = StudentJdbcUtils.getConnection();
            // 4.获取执行者对象
            statement = connection.createStatement();
            // 5.执行sql语句获取返回结果
            Integer len = statement.executeUpdate("update student  set name='" + student.getName() + "' ,age=" + student.getAge() + "," + "address='" + student.getAddress() + "' where id=" + student.getId() + "");
            // 6.对返回结果进行处理
            return len;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            // 7.释放资源
            StudentJdbcUtils.closeConnection(statement,connection);
        }
    }

    /**
     * 5.根据主键id删除学生信息
     */
    public Integer deleteStu(Integer stuId){
        if(stuId == null){
            return 0;
        }
        Connection connection = null;
        Statement statement = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            connection = StudentJdbcUtils.getConnection();
            // 4.获取执行者对象
            statement = connection.createStatement();
            // 5.执行sql语句获取返回结果
            Integer len = statement.executeUpdate("delete from student where id = "+stuId);
            // 6.对返回结果进行处理
            return len;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            // 7.释放资源
            StudentJdbcUtils.closeConnection(statement,connection);
        }
     }
}
