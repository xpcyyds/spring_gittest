package com.cdcompany.dao;

import com.cdcompany.entity.Student;
import com.cdcompany.entity.User;
import com.cdcompany.utils.StudentJdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao {

    /**
     * 1.注册用户
     * @param user
     * @return
     */
    public boolean registerUser(User user){
        Connection connection = null;
        Statement statement = null;
        // 1.导入jar包
        // 2.注册驱动
        try {
            connection = StudentJdbcUtils.getConnection();
            // 4.获取执行者对象
            statement = connection.createStatement();
            // 5.执行sql语句获取返回结果
            int len = statement.executeUpdate("insert into user (userPhone, userPwd)" +
                    " VALUES ('"+user.getUserPhone()+"','"+user.getUserPwd()+"')");
            // 6.对返回结果进行处理

            if(len != 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            // 7.释放资源
            StudentJdbcUtils.closeConnection(statement,connection);
        }
    }

    /**
     * 2.登录用户
     * @param user
     * @return
     */
    public boolean loginUser(User user){
        Connection connection = null;
        PreparedStatement statement = null;
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

            String sql = "select * from user where userPhone = ? and userPwd = ?";
            statement= connection.prepareStatement(sql);
            statement.setString(1,user.getUserPhone());
            statement.setString(2,user.getUserPwd());
            // 5.执行sql语句获取返回结果
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
            // 6.对返回结果进行处理
            System.out.println(sql);
            if(!resultSet.next()){
                return false;
            }else {
                return true;
            }


        }catch (Exception e){
            e.printStackTrace();
            return false;
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
}
