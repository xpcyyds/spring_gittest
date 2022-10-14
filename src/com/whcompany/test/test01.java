package com.whcompany.test;

import com.whcompany.entity.Foods;
import com.whcompany.service.FoodsService;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class test01 {
    private static FoodsService foodsService = new FoodsService();
    public static void main(String[] args) {
        while (true){
            homepage();
        }
    }

    public static void homepage(){
        System.out.println("欢迎来到餐前选食时间，按下数字进行选择:");
        System.out.println("1.一食堂");
        System.out.println("2.二食堂");
        System.out.println("0.进行随机抽取数字选择所要去的食堂");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num == 0) {
            try {
                Thread.sleep(1000);//单位：毫秒
            } catch (Exception e) {
            }
            Random random = new Random();
            int canteenNum = random.nextInt(2);
            if (canteenNum == 0) {
                System.out.println("随机数为" + canteenNum + "去一食堂吃饭");
                try {
                    Thread.sleep(1000);//单位：毫秒
                } catch (Exception e) {
                }
                CanteenPage(canteenNum);
            } else {
                System.out.println("随机数为" + canteenNum + "去二食堂吃饭");
                CanteenPage(canteenNum);
            }
        }
    }

    public static void CanteenPage(int canteenNum) {
        System.out.println("欢迎来到一食堂！");
        System.out.println("一食堂拥有以下食品种类：");
        ArrayList<Foods> foods = new ArrayList<>();
        foods = foodsService.selectFirstFoodsClass(canteenNum);
        for (Foods food:foods) {
            System.out.println("["+food.getFoodsClass()+"]");
        }
        System.out.println("按下数字0进行随机抽取选择食品种类");

        int randomNum = foods.size();
        Scanner scanner = new Scanner(System.in);
        int scannerNum = scanner.nextInt();
        if (scannerNum == 0) {
            try {
                Thread.sleep(1000);//单位：毫秒
            } catch (Exception e) {
            }
            Random random = new Random();
            int num2 = random.nextInt(randomNum);
            System.out.println("食物种类为"+foods.get(num2).getFoodsClass());
            foodsChoose(foods.get(num2).getId(),canteenNum);
        }
    }

    public static void foodsChoose(int parentId,int canteenNum){
        System.out.println("该食品种类对应的店铺如下：");
        ArrayList<Foods> foods = new ArrayList<>();
        foods = foodsService.selectFoodsByParentId( parentId, canteenNum);
        for (Foods food:foods) {
            System.out.println("["+food.getFoodsClass()+"]");
        }
        System.out.println("按下数字0进行选择该食物相应的店铺");

        int randomNum = foods.size();
        Scanner scanner = new Scanner(System.in);
        int scannerNum = scanner.nextInt();
        if (scannerNum == 0) {
            try {
                Thread.sleep(1000);//单位：毫秒
            } catch (Exception e) {
            }
            Random random = new Random();
            int num2 = random.nextInt(randomNum);
            System.out.println("最终选择店铺为"+foods.get(num2).getFoodsClass());

        }

    }


}
