package com.guimei.zxj.dao.impl;

import com.guimei.zxj.dao.ProductDao;
import com.guimei.zxj.pojo.CartRec;
import com.guimei.zxj.pojo.Product;
import com.guimei.zxj.pojo.Seller;

import java.util.List;

/***
 * 作者：张萱瑾
 */

public class ProductDaoImpl extends BaseDao implements ProductDao {


    @Override
    public Product getProductById(Integer pid) {
        String sql="select * from product where pid=?";
        return queryForOne(Product.class,sql,pid);
    }

    @Override
    public Product getProductByName(String pName) {
        String sql="select * from product where pName = ? ";
        return queryForOne(Product.class,sql,pName);
    }

    @Override
    public Product gteProductByDes(String des) {
        String sql="select * from product where des=? ";
        return queryForOne(Product.class,sql,des);
    }

    @Override
    public Seller getSeller(String sname) {
        String sql="select * from seller where sname =?  ";
        return queryForOne(Seller.class,sql,sname);
    }


    @Override
    public Integer getId(String pName) {
        String sql="select * from product where pName = ?";
        return queryForOne(Integer.class,sql,pName);
    }

    @Override
    public Integer getProductFromRec(Integer uid, Integer pid) {
        return null;
    }

    @Override
    public Integer addToCollection(Integer pid,Integer uid,String pName) {
        String sql="insert into collection(uid,pid,pName)values(uid,pid,pName)";
        return update(sql,uid,pid,pName);
    }



    //根据类别分页查询商品信息
    @Override
    public List<Product> queryForPageItems(String catName, int begin, int pageSize) {
        String sql = "select * from product where catName=?  limit ?,?";
        return queryForList(Product.class,sql,begin,pageSize);
    }


    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from product";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }


    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from product where pri between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<CartRec> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select * from product where pri between ? and ? order by pri limit ?,?";
        return queryForList(CartRec.class,sql,min,max,begin,pageSize);
    }



}
