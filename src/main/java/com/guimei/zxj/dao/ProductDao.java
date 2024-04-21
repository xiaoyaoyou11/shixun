package com.guimei.zxj.dao;

import com.guimei.zxj.pojo.CartRec;
import com.guimei.zxj.pojo.Product;
import com.guimei.zxj.pojo.Seller;

import java.util.List;

/***
 * 作者：张萱瑾
 */

public interface ProductDao {

    public Product getProductById(Integer pid);
    public Product getProductByName(String pName);
    public Product gteProductByDes(String des);

    public Seller getSeller(String sname);

    public Integer getId(String pName);  //查询出商品对应id；

    public Integer getProductFromRec(Integer uid,Integer pid);

    Integer addToCollection(Integer pid, Integer uid, String pName);


    //根据类别分页查询商品信息
    List<Product> queryForPageItems(String catName, int begin, int pageSize);

    Integer queryForPageTotalCount();

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<CartRec> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
