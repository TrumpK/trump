package com.yuk.trump.service.Impl;

import com.yuk.trump.entity.Log;
import com.yuk.trump.mapper.LogMapper;
import com.yuk.trump.service.LogService;
import com.yuk.trump.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:10
 * @description：LogServiceImpl
 * @modified By：
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void insertByLog(Log log) {
        logMapper.insertByLog(log);
    }

    @Override
    public PageBean<Log> queryPage(Map<String, Object> paramMap) {
        PageBean<Log> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Log> datas = logMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = logMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int delByLogIds(List<Integer> ids) {
        return logMapper.delByLogIds(ids);
    }
}
