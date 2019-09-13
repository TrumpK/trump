package com.yuk.trump.mapper;

import com.yuk.trump.entity.TreeMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:06
 * @description：TreeMenuMapper
 * @modified By：
 */
public interface TreeMenuMapper {
    List<TreeMenu> selectByAdminId(Integer id);

    List<TreeMenu> selectAll();

    TreeMenu selectById(Integer id);

    TreeMenu selectByName(String name);

    TreeMenu selectByUrl(String url);

    int editByPermission(TreeMenu treeMenu);

    int insertPermission(TreeMenu treeMenu);

    int delByPermissionIds(List<Integer> ids);

    void delRolePermission(List<Integer> ids);

    List<TreeMenu> selectByPid(Integer id);

    List<TreeMenu> selectByRoleId(Integer id);

    int updateRolePermission(@Param("ids") List<Integer> ids, @Param("id") Integer id);

    void delRolePermissionByRid(Integer id);
}

