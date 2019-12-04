
package com.funtl.my.shop.web.admin.service.test;

import com.funtl.my.shop.domain.TbUser;
import com.funtl.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;


/**
 * @program: my-shop
 * @description: 测试service看是否拿到数据（查询所有）
 * @author: wule
 * @create: 2019-08-02 16:01
 **/


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;


    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.printf(tbUser.getUsername());
        }

    }

    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setUsername("zhangsan4");
        tbUser.setEmail("wule666@qq.com");
        tbUser.setCreated(new Date());
        //tbUser.setPassword("123456");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
        tbUser.setUpdated(new Date());

        tbUserService.insert(tbUser);
    }



    @Test
    public void testGetById() {
        TbUser tbUser = tbUserService.getById(42L);
        System.out.println(tbUser.getUsername());
    }

    @Test
    public void testUpdate() {

        TbUser tbUser = tbUserService.getById(42L);
        tbUser.setUsername("wule");

        tbUserService.update(tbUser);

    }


    @Test
    public void selectByUsername() {
        List<TbUser> tbUsers = tbUserService.selectByUsername("zhang");
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }

    }


    @Test
    public void testDelete() {
        tbUserService.delete(12L);
    }


    @Test
    public void testMD5() {
        System.out.println(DigestUtils.md5DigestAsHex("123".getBytes()));

    }


}
