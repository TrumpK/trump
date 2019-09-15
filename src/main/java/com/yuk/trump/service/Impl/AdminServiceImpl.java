package com.yuk.trump.service.Impl;

import com.google.common.base.Joiner;
import com.yuk.trump.entity.Admin;
import com.yuk.trump.mapper.AdminMapper;
import com.yuk.trump.redis.RedisService;
import com.yuk.trump.redis.UserKey;
import com.yuk.trump.result.CodeMsg;
import com.yuk.trump.service.AdminService;
import com.yuk.trump.util.AESUtil;
import com.yuk.trump.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    private RedisService redisService;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        Admin admin = adminMapper.login(username,password);
        Integer userId = admin.getId();
        System.out.println("current user is " + username + ":" + userId);
        if (!StringUtils.isEmpty(this.checkTokenById(userId))){
            return null;
        }
        try {
            this.getToken(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public boolean logout(Integer userId) {
        String id_temp = userId.toString();
        try {
            String token = AESUtil.encryptByDefaultKey(Joiner.on("_").join(id_temp, System.currentTimeMillis()));
        }catch (Exception e){
            e.printStackTrace();
        }
        if (redisService.delete(UserKey.userAccessKey, id_temp)){
            return false;
        }
        return true;
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

    @Override
    public String getToken(Integer id) throws Exception {
        String id_temp = id.toString();
        String token = AESUtil.encryptByDefaultKey(Joiner.on("_").join(id_temp, System.currentTimeMillis()));
        redisService.set(UserKey.userAccessKey, id_temp, token);
        return token;
    }

    public String checkTokenById(Integer id){
        String currentToken = redisService.get(UserKey.userAccessKey, id.toString(), String.class);
        if (!StringUtils.isEmpty(currentToken)){
            return CodeMsg.LOGIN_FAILURE.toString();
        }
        return null;
    }


    public String checkToken(String token) throws Exception {
        String userId = AESUtil.decryptByDefaultKey(token).split("_")[0];
        String currentToken = redisService.get(UserKey.userAccessKey, userId, String.class);
        if (StringUtils.isEmpty(currentToken)) {
            return null;
        }
        if (!token.equals(currentToken)) {
            return null;
        }
        return userId;
    }

}
