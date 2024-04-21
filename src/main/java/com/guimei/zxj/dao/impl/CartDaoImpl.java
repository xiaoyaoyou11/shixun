package com.guimei.zxj.dao.impl;

import com.guimei.zxj.dao.CartRecDao;
import com.guimei.zxj.pojo.CartRec;


import java.util.List;
import java.util.Map;


/***
 * 作者：张萱瑾
 */

public class CartDaoImpl  extends BaseDao implements CartRecDao {

    //用户下次查看给购物车的时候只需要显示购物车商品的基本信息不需要显示以前购买的历史数量和总价
    public Integer addCartRec(CartRec cartRec){
      String sql="insert into cartrec (uid,cid,pid,pri,discount,pName,date)values(?,?,?,?,?,?,?)";
      return update(sql,cartRec.getUid(),cartRec.getCid(),cartRec.getPid(),cartRec.getPid(),cartRec.getPri(),cartRec.getDiscount(),cartRec.getpName(),cartRec.getDate());
    }

    @Override
    public Integer saveCart(Map<Integer, CartRec> cart) {
        Integer result=0;
        for (CartRec cartRec: cart.values()) {
            result =addCartRec(cartRec);
        }
        return result;
    }

    public Integer clear(Integer uid){
        String sql="delete from cartrec where uid=?";
        return update(sql,uid);
    }


    @Override
    public List<CartRec> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from cartrec limit ?,?";
        return queryForList(CartRec.class,sql,begin,pageSize);
    }


    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from cartrec";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }


    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from cartrec where pri between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<CartRec> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select * from product where pri between ? and ? order by pri limit ?,?";
        return queryForList(CartRec.class,sql,min,max,begin,pageSize);
    }
}
