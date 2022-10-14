package com.whcompany.service;

import com.whcompany.dao.FoodsDao;
import com.whcompany.entity.Foods;

import java.util.ArrayList;

public class FoodsService {

    private FoodsDao foodsDao = new FoodsDao();

    public ArrayList<Foods> selectFirstFoodsClass(int num){
        return foodsDao.selectFirstFoodsClass(num);
    }

    public ArrayList<Foods> selectFoodsByParentId(int parentId, int canteenNum){
        return foodsDao.selectFoodsByParentId(parentId,canteenNum);
    }

}
