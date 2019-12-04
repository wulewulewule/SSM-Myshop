package com.funtl.my.shop.web.admin.service;

import com.funtl.my.shop.commons.dto.BaseResult;
import com.funtl.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {
     List<TbUser> selectAll();

    void insert(TbUser tbUser);

    void delete(Long id);

    TbUser getById(Long id);

    void update(TbUser tbUser);

    BaseResult save(TbUser tbUser);

    List<TbUser> selectByUsername(String username);

    //用户登录
    TbUser login(String email,String password);

    //搜索
    List<TbUser> search(TbUser tbUser);

}
