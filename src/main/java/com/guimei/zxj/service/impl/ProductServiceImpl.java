package com.guimei.zxj.service.impl;

import com.guimei.zxj.dao.ProductDao;
import com.guimei.zxj.dao.UserDao;
import com.guimei.zxj.dao.impl.ProductDaoImpl;
import com.guimei.zxj.dao.impl.UserDaoImpl;
import com.guimei.zxj.pojo.Page;
import com.guimei.zxj.pojo.Product;
import com.guimei.zxj.pojo.Seller;
import com.guimei.zxj.service.ProductService;

import java.util.List;


/***
 * 作者：张萱瑾
 */

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao=new ProductDaoImpl();
    private final UserDao userDao=new UserDaoImpl();


    @Override
    public Integer getId(String pName) {
        return productDao.getId(pName);
    }

    @Override
    public Product getOneProduct(Integer pid) {
       return productDao.getProductById(pid);
    }

    @Override
    public Product getProductByPName(String pName) {
        Product product=productDao.getProductByName(pName);
        return product;
    }

    @Override
    public Product getProductByDes(String des) {
        return  productDao.gteProductByDes(des);
    }

    @Override
    public Integer addToCollection(Integer uid, Integer pid, String pName) {
        //获取商品编号然后加入收藏夹
        return  productDao.addToCollection(uid,pid,pName);
    }

    @Override
    public Seller getSeller(String sname) {
        return productDao.getSeller(sname);
    }

    @Override
    public Page<Product> page(String catName, Integer pageNo, Integer pageSize) {

        Page<Product> page = new Page<Product>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = productDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Product> items = productDao.queryForPageItems(catName,pageNo,pageSize);
        // 设置当前页数据
        page.setItems(items);
        return page;
    }

}
