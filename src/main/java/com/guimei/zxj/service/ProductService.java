package com.guimei.zxj.service;

import com.guimei.zxj.pojo.Page;
import com.guimei.zxj.pojo.Product;
import com.guimei.zxj.pojo.Seller;

/***
 * 作者：张萱瑾
 */

public interface ProductService {
    public Integer getId(String pName);
    public Product getOneProduct(Integer pid);
    public Product getProductByPName(String pName);
    public Product getProductByDes(String des);
    public Integer addToCollection(Integer uid,Integer pid, String pName);
    //收藏记录表
    //加入用户的收藏夹
    public Seller getSeller(String sname);
    public Page<Product> page(String catName, Integer pageNo, Integer pageSize);

}
