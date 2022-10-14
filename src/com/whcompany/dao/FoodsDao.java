package com.whcompany.dao;

import com.cdcompany.entity.Student;
import com.cdcompany.utils.StudentJdbcUtils;
import com.whcompany.entity.Foods;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodsDao {

    public ArrayList<Foods> selectFirstFoodsClass(int num) {
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
            if(num == 0){
                resultSet = statement.executeQuery("select * from first_canteen where parentId =0");
            }else {
                resultSet = statement.executeQuery("select * from second_canteen where parentId=0");
            }

            // 6.对返回结果进行处理
            ArrayList<Foods> foodsEntities = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String foodsClass = resultSet.getString("foodsClass");
                Integer parentId = resultSet.getInt("parentId");
                Foods foods = new Foods(id, foodsClass, parentId);
                foodsEntities.add(foods);
            }
            return foodsEntities;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 7.释放资源
            StudentJdbcUtils.closeConnection(resultSet, statement, connection);
        }
    }

    public ArrayList<Foods> selectFoodsByParentId(int parentId,int canteenNum){
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
            if(canteenNum == 0){
                resultSet = statement.executeQuery("select * from first_canteen where parentId ="+parentId);
            }else {
                resultSet = statement.executeQuery("select * from second_canteen where parentId= "+parentId);
            }

            // 6.对返回结果进行处理
            ArrayList<Foods> foodsEntities = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String foodsClass = resultSet.getString("foodsClass");
                Integer parentsId = resultSet.getInt("parentId");
                Foods foods = new Foods(id, foodsClass, parentsId);
                foodsEntities.add(foods);
            }
            return foodsEntities;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 7.释放资源
            StudentJdbcUtils.closeConnection(resultSet, statement, connection);
        }
    }
}
