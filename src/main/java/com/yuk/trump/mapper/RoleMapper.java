package com.yuk.trump.mapper;

import com.yuk.trump.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:06
 * @description：RoleMapper
 * @modified By：
 */
public interface RoleMapper {
    List<Role> selectAll();

    List<Role> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int delByRoleIds(List<Integer> ids);

    Role selectById(Integer id);

    Role selectByName(String name);

    int editByRole(Role role);

    int insertRole(Role role);
}

