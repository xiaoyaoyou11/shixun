package com.guimei.zxj.service;

import com.guimei.zxj.pojo.CartRec;
import com.guimei.zxj.pojo.Page;

import java.util.Map;

/***
 * 作者：张萱瑾
 */

public interface CartRecService{

    //每次结算订单的是否保存购物车的部分数据到数据库，注意去重（重复购买的商品的记录只保存一条即可
    public Integer saveCart(Map<Integer , CartRec> cart);

    //删除购物车
    public Integer clearCart(Integer uid);

    //获取购物车的商品分页的记录
    public Page getCartRecPages(Integer begin, Integer pageSize);
}
