package com.yuk.trump.service;

import com.yuk.trump.entity.Role;
import com.yuk.trump.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:09
 * @description：RoleService
 * @modified By：
 */
public interface RoleService {
    List<Role> selectAll();

    PageBean<Role> queryPage(Map<String, Object> paramMap);

    int delByRoleIds(List<Integer> ids);

    Role selectById(Integer id);

    Role selectByName(String name);

    int editByRole(Role role);

    int insertRole(Role role);
}
