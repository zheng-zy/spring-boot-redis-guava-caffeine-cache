package com.cache.me.service;

import com.cache.me.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * desc: 服务数据提供
 * author: zhengzy
 * date: 2016/8/12
 */
@Service
public class DemoService {

    @Cacheable(value = "userCache", keyGenerator = "KeyGenerator")
    public User findUser(Long id, String firstName, String lastName) {
        System.out.println("db qry");
        return new User(id, firstName, lastName);
    }

    @Cacheable(value = "userListCache", keyGenerator = "KeyGenerator")
    public List<User> findUserList(Long companyId) {
        System.out.println("db qry list");
        List<User> list = new ArrayList<>();
        list.add(new User(1L, "zheng", "zhiyong"));
        list.add(new User(2L, "xiao", "ming"));
        return list;
    }

    @Cacheable(value = "userCacheById", key = "'key:'+#id.toString()")
    public User findUserById(Long id) {
        System.out.println("db custom qry");
        return new User(id, "xiao", "ming");
    }

    @CacheEvict(value = "userCacheById", key = "'key:'+#id.toString()")
    public int delUserById(Long id) {
        System.out.println("db custom del");
        return 1;
    }
}
