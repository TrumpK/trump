package com.yuk.trump.mapper;

import com.yuk.trump.entity.Admin;

import java.util.List;
import java.util.Map;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:05
 * @description：AdminMapper
 * @modified By：
 */
public interface AdminMapper {

    Admin login(String username, String password);

    List<Admin> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int insertAdmin(Admin admin);

    Admin selectById(Integer id);

    int delByAdminIds(List<Integer> ids);

    int editByAdmin(Admin admin);

    Admin selectByName(String username);

    Admin selectByEmail(String email);
}