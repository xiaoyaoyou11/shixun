package com.guimei.zxj.dao;

import com.guimei.zxj.pojo.User;

/***
 * 作者：张萱瑾
 */

public interface UserDao  {
    public Integer getUid(String userName);

    public User getUser(String username);

    public  Integer deleteUser(String username);

    public Integer insertUser(User user);
}
