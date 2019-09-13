package com.yuk.trump.service;

import com.yuk.trump.entity.TreeMenu;

import java.util.List;
/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:09
 * @description：TreeMenuService
 * @modified By：
 */
public interface TreeMenuService {

    List<TreeMenu> selectByAdminId(Integer id);


    List<TreeMenu> selectAll();

    TreeMenu selectById(Integer id);

    TreeMenu selectByName(String name);

    TreeMenu selectByUrl(String url);

    int editByPermission(TreeMenu treeMenu);

    int insertPermission(TreeMenu treeMenu);

    int delByPermissionIds(List<Integer> ids);

    List<TreeMenu> selectByPid(Integer id);

    List<TreeMenu> selectByRoleId(Integer id);

    int updateRolePermission(List<Integer> ids, Integer id);
}

