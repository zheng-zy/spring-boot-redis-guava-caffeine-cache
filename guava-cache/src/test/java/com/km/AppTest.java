package com.km;

import com.km.entity.User;
import com.km.service.UserService;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * 测试缓存是否生效
     */
    @Test
    public void test() {
        UserService userService = UserService.INSTANCE;
        User user = userService.get(1L);
        System.out.println(user.getName());
        user.setName("haha");
        System.out.println(user.getName());
        User user1 = userService.get(1L);
        System.out.println(user1.getName());
        // 删除缓存中数据
        userService.remove(1L);
        User user2 = userService.get(1L);
        System.out.println(user2.getName());
    }

}
