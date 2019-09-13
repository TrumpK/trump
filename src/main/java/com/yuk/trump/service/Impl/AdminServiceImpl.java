package com.yuk.trump.service.Impl;

import com.yuk.trump.entity.Admin;
import com.yuk.trump.mapper.AdminMapper;
import com.yuk.trump.service.AdminService;
import com.yuk.trump.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:09
 * @description：
 * @modified By：
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        return adminMapper.login(username,password);
    }

    @Override
    public PageBean<Admin> queryPage(Map<String, Object> paramMap) {
        PageBean<Admin> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Admin> datas = adminMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = adminMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public Admin selectById(Integer id) {
        return adminMapper.selectById(id);
    }

    @Override
    public int delByAdminIds(List<Integer> ids) {
        return adminMapper.delByAdminIds(ids);
    }

    @Override
    public int editByAdmin(Admin admin) {
        return adminMapper.editByAdmin(admin);
    }

    @Override
    public Admin selectByName(String username) {
        return adminMapper.selectByName(username);
    }

    @Override
    public Admin selectByEmail(String email) {
        return adminMapper.selectByEmail(email);
    }
}
