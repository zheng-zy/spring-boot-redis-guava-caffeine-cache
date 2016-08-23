package com.cache.me.service;

import com.cache.me.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 服务数据提供
 * @author: zhengzy
 * @date: 2016/8/12
 */
@Service
public class DemoService {

    @Cacheable(value = "usercache", keyGenerator = "KeyGenerator")
    public User findUser(Long id, String firstName, String lastName) {
        System.out.println("db qry");
        return new User(id, firstName, lastName);
    }
    @Cacheable(value = "userlistcache", keyGenerator = "KeyGenerator")
    public List<User> findUserList(Long companyId) {
        System.out.println("db qry list");
        List<User> list = new ArrayList<>();
        list.add(new User(1l,"zheng", "zhiyong"));
        list.add(new User(2l,"xiao", "ming"));
        return list;
    }
}
