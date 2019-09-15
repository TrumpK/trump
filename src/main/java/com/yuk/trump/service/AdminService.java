package com.yuk.trump.service;

import com.yuk.trump.entity.Admin;
import com.yuk.trump.util.PageBean;

import java.util.List;
import java.util.Map;
/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:08
 * @description：AdminService
 * @modified By：
 */
public interface AdminService {

    Admin login(String username, String password);

    PageBean<Admin> queryPage(Map<String, Object> paramMap);

    int insertAdmin(Admin admin);

    Admin selectById(Integer id);
    int delByAdminIds(List<Integer> ids);


    int editByAdmin(Admin admin);

    Admin selectByName(String username);

    Admin selectByEmail(String email);
}
