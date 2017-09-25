package com.km.service;

import com.km.cache.CacheService;
import com.km.db.UserDao;
import com.km.entity.User;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/9/25.
 */
public class UserService extends CacheService<Long, User> {

    public static UserService INSTANCE = new UserService();
    private UserDao userDao = new UserDao();

    @Override
    public User load(Long id) throws Exception {
        System.out.println("query db");
        return userDao.select("select * from user where id=" + id);
    }
}
