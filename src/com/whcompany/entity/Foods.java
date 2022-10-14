package com.whcompany.entity;

import sun.applet.AppletResourceLoader;

public class Foods {
    private Integer id;
    private String foodsClass;
    private Integer parentId;

    @Override
    public String toString() {
        return "Foods{" +
                "id=" + id +
                ", foodsClass='" + foodsClass + '\'' +
                ", parentId=" + parentId +
                '}';
    }

    public Foods(Integer id, String foodsClass, Integer parentId) {
        this.id = id;
        this.foodsClass = foodsClass;
        this.parentId = parentId;
    }

    public Foods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodsClass() {
        return foodsClass;
    }

    public void setFoodsClass(String foodsClass) {
        this.foodsClass = foodsClass;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
