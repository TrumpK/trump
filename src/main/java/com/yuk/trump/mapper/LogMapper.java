package com.yuk.trump.mapper;

import com.yuk.trump.entity.Log;

import java.util.List;
import java.util.Map;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:06
 * @description：LogMapper
 * @modified By：
 */
public interface LogMapper {
    void insertByLog(Log log);

    List<Log> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int delByLogIds(List<Integer> ids);
}

