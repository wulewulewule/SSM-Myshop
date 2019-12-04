package com.funtl.my.shop.web.admin.dao;

//定义数据访问接口

import com.funtl.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserDao {
    //查询所有
    List<TbUser> selectAll();
    //插入
    void insert(TbUser tbUser);
    //删除
    void delete(Long id);
    //根据ID查询用户信息(改)
    TbUser getById(Long id);
    //更新
    void update(TbUser tbUser);
    //模糊查询(根据用户名)
    List<TbUser> selectByUsername(String username);

    //根据邮箱查询用户信息
    TbUser getByEmail(String email);

    //模糊搜索
    List<TbUser> search(TbUser tbUser);
}
