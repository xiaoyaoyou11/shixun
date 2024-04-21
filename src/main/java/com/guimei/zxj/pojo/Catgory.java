package com.guimei.zxj.pojo;


/***
 * 作者：张萱瑾
 */

//商品类别描述
public class Catgory {
    private Integer id;//商品的编号
    private String catName;//商品类别名称

    public Catgory(Integer id, String catName) {
        this.id = id;
        this.catName = catName;
    }

    public Catgory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }


}
