package com.guimei.zxj.web;

import com.guimei.zxj.pojo.Page;
import com.guimei.zxj.pojo.Product;
import com.guimei.zxj.pojo.Seller;
import com.guimei.zxj.service.ProductService;
import com.guimei.zxj.service.impl.ProductServiceImpl;
import com.guimei.zxj.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/***
 * 作者：张萱瑾
 */

public class ProductServlet extends BaseServlet{

    private ProductService productService=new ProductServiceImpl();


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        String catName=req.getParameter("catName");
        Page<Product> page = productService.page(catName,pageNo,pageSize);
        page.setUrl("productServlet?action=page");

        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/calist.jsp").forward(req,resp);
    }



    public void getOneProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pName=req.getParameter("pName");
       Product product= productService.getProductByPName(pName);
       req.setAttribute("product",product);
       req.getRequestDispatcher("./pages/info.jsp").forward(req,resp);
    }
    public void addToCollection(HttpServletRequest req, HttpServletResponse resp){
        String pName=req.getParameter("pName");
        HttpSession httpSession= req.getSession();
        Integer uid=(Integer)httpSession.getAttribute("uid");
        Integer pid=productService.getId(pName);
        productService.addToCollection(uid,pid,pName);  //封装异常

    }

    public void getSeller(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sname=req.getParameter("sname");
        Seller seller=productService.getSeller(sname);
        req.setAttribute("seller",seller);
        req.getRequestDispatcher("./pages/seller.jsp").forward(req,resp);
    }

    public void getProductByDes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String des=req.getParameter("des");
        Product product=productService.getProductByDes(des);
        req.setAttribute("product",product);
        req.getRequestDispatcher("./pages/info.jsp").forward(req,resp);
    }
}
