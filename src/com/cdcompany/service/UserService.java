package com.cdcompany.service;

import com.cdcompany.dao.StudentDao;
import com.cdcompany.dao.UserDao;
import com.cdcompany.entity.User;

public class UserService {
    /**
     * new 学生对象dao层
     */
    private UserDao userDao = new UserDao();

    /**
     * 1.注册用户
     * @param user
     * @return
     */
    public boolean registerUser(User user){
        boolean bl = userDao.registerUser(user);
        return bl;
    }

    /**
     * 2.登录用户
     * @param user
     * @return
     */
    public boolean loginUser(User user){
        boolean bl = userDao.loginUser(user);
        return bl;
    }


}
