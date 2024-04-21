package com.guimei.zxj.web;

import com.guimei.zxj.pojo.Cart;
import com.guimei.zxj.pojo.CartRec;
import com.guimei.zxj.pojo.Page;
import com.guimei.zxj.pojo.Product;
import com.guimei.zxj.service.CartRecService;
import com.guimei.zxj.service.ProductService;
import com.guimei.zxj.service.impl.CartServiceImpl;
import com.guimei.zxj.service.impl.ProductServiceImpl;
import com.guimei.zxj.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/***
 * 作者：张萱瑾
 */

public class CartServlet {
    private CartRecService cartRecService=new CartServiceImpl();
    private ProductService productService=new ProductServiceImpl();

    //删除和修改购物车的操作只是和session进行交互，保存历史购物车记录才会恶化数据库进行交互
    protected  void deleteCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.valueOf(req.getParameter("id"));
        HttpSession session=req.getSession();
        Map<Integer , CartRec> cartRecMap=(Map<Integer, CartRec>) session.getAttribute("cart");
        cartRecMap.remove(id);
        req.getRequestDispatcher("./pages/buy.jsp").forward(req,resp);

    }
    protected void modifyCartRec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.valueOf(req.getParameter("id"));
        Integer num=Integer.valueOf(req.getParameter("num"));
        HttpSession session=req.getSession();
        Map<Integer ,CartRec> cartRecMap=(Map<Integer, CartRec>) session.getAttribute("cart");
        CartRec cartRec=cartRecMap.get(id);
        cartRec.setNum(num);
        req.getRequestDispatcher("./pages/buy.jsp").forward(req,resp);
    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<CartRec> page = cartRecService.getCartRecPages(pageNo,pageSize);
        page.setUrl("cartRecServlet?action=page");
        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        req.getRequestDispatcher("./pages/buy.jsp").forward(req,resp);
    }


    protected  void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();//获取session中的uid；
        Integer uid=(Integer) session.getAttribute("uid");
        cartRecService.clearCart(uid);
        req.getRequestDispatcher("./pages/buy.jsp").forward(req,resp);
    }

    protected  void saveCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();//获取session中的uid；
        Map<Integer,CartRec> cartRecMap=(Map<Integer,CartRec> )session.getAttribute("cart");
        cartRecService.saveCart(cartRecMap);
        req.getRequestDispatcher("./pages/buy.jsp").forward(req,resp);
    }



    protected void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        Map<Integer,CartRec> cartRecMap=(Map<Integer, CartRec>) session.getAttribute("cart");
        if(cartRecMap==null){
            cartRecMap=new HashMap<Integer,CartRec>() ;
            session.setAttribute("cart",cartRecMap);
        }else{
            Integer pid= Integer.valueOf(req.getParameter("pid"));
            CartRec cartRec=new CartRec();
            Product product=productService.getOneProduct(pid);
            cartRec.setpName(product.getpName());
            cartRec.setPri(product.getPrice());
            cartRec.setDiscount(product.getDiscount());
            Cart cart=new Cart();
            cart.setCart((Map<Integer, CartRec>) session.getAttribute("cart"));
            cart.addItem(cartRec);
        }
        req.getRequestDispatcher("./pages/buy.jsp").forward(req,resp);

    }






}
