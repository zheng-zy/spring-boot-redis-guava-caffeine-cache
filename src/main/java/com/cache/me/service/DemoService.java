package com.cache.me.service;

import com.cache.me.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @desc: 服务数据提供
 * @author: zhengzy
 * @date: 2016/8/12
 */
@Service
public class DemoService {

    @Cacheable(value = "usercache", keyGenerator = "wiselyKeyGenerator")
    public User findUser(Long id, String firstName, String lastName) {
        System.out.println("db qry");
        return new User(id, firstName, lastName);
    }

}
