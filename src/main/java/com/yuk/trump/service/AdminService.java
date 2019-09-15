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

    boolean logout(Integer userId);

    PageBean<Admin> queryPage(Map<String, Object> paramMap);

    int insertAdmin(Admin admin);

    Admin selectById(Integer id);

    int delByAdminIds(List<Integer> ids);

    int editByAdmin(Admin admin);

    Admin selectByName(String username);

    Admin selectByEmail(String email);

    /**
     * 获取token
     * @param userId
     * @return
     * @throws Exception
     */
    String getToken(Integer id) throws Exception;

    /**
     * 校验Token
     * @param token
     * @return
     * @throws Exception
     */
    String checkToken(String token) throws Exception;
}
