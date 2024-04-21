package com.guimei.zxj.dao;

import com.guimei.zxj.pojo.CartRec;

import java.util.List;
import java.util.Map;


/***
 * 作者：张萱瑾
 */

//把用户的购物车记录存储在session中加快查询的速度 cartrec中只是存储的用户的历史的购物记录
//用户对于cartrec的增删操作只需要修改session然后写入到订单记录表中

public interface CartRecDao {

    //删除所有的购物车记录
    public Integer clear(Integer uid);

    //把购物车里面的数据保存到本地数据库中
    public Integer saveCart(Map<Integer, CartRec> cart);
    //分页查询购物车记录
    public List<CartRec >queryForPageItems(int begin, int pageSize) ;


    Integer queryForPageTotalCount();

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<CartRec> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
