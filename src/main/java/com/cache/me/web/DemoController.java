package com.cache.me.web;

import com.cache.me.entity.User;
import com.cache.me.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * desc: 控制器
 * author: zhengzy
 * date: 2016/8/12
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testCache() {
        User user = demoService.findUser(1L, "first", "last");
        System.out.println("user:" + "/" + user.getFirstName() + "/" + user.getLastName());
        return "ok";
    }

    @RequestMapping(value = "/testList", method = RequestMethod.GET)
    public String testCacheList(){
        List<User> list = demoService.findUserList(1L);
        System.out.println(list.size());
        return "list";
    }

    @RequestMapping(value = "/testId", method = RequestMethod.GET)
    public String testById() {
        User user = demoService.findUserById(1L);
        System.out.println("user:" + "/" + user.getFirstName() + "/" + user.getLastName());
        return "testById";
    }

    @RequestMapping(value = "/testDelId", method = RequestMethod.GET)
    public String testDelId() {
        int result = demoService.delUserById(1L);
        System.out.println("testDelId:" + result);
        return "testDelId";
    }




}
