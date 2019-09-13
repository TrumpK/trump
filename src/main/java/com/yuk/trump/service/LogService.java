package com.yuk.trump.service;

import com.yuk.trump.entity.Log;
import com.yuk.trump.util.PageBean;

import java.util.List;
import java.util.Map;
/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 12:59
 * @description：LogService
 * @modified By：
 */
public interface LogService {
    void insertByLog(Log log);

    PageBean<Log> queryPage(Map<String, Object> paramMap);

    int delByLogIds(List<Integer> ids);
}
