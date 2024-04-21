package com.guimei.zxj.service.impl;

import com.guimei.zxj.dao.CartRecDao;
import com.guimei.zxj.dao.impl.CartDaoImpl;
import com.guimei.zxj.pojo.CartRec;
import com.guimei.zxj.pojo.Page;
import com.guimei.zxj.service.CartRecService;

import java.util.List;
import java.util.Map;

/***
 * 作者：张萱瑾
 */

public class CartServiceImpl implements CartRecService {

    private CartRecDao cartRecDao=new CartDaoImpl();

    @Override
    public Integer saveCart(Map<Integer, CartRec> cart) {
        return cartRecDao.saveCart(cart);
    }

    @Override
    public Integer clearCart(Integer uid) {
       return clearCart(uid);
    }

    //都购物记录进行分页查询
    @Override
    public Page getCartRecPages(Integer pageSize, Integer pageNo) {
        Page<CartRec> page = new Page<CartRec>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = cartRecDao.queryForPageTotalCount();
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
        List<CartRec> items = cartRecDao.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;

    }
}
