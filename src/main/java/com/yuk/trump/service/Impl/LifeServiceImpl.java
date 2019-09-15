package com.yuk.trump.service.Impl;

import com.yuk.trump.entity.Consume;
import com.yuk.trump.mapper.LifeMapper;
import com.yuk.trump.service.LifeService;
import com.yuk.trump.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/14 12:33
 * @description：
 * @modified By：
 */
@Service
public class LifeServiceImpl implements LifeService {
    @Autowired
    LifeMapper lifeMapper;

    @Override
    public PageBean<Consume> queryConsumePage(Map<String, Object> paramMap) {
        PageBean<Consume> pageBean = new PageBean<>((Integer) paramMap.get("pageno"), (Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex", startIndex);
        List<Consume> datas = lifeMapper.queryConsumeList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = lifeMapper.queryConsumeCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int insertConsume(Consume consume) {
        return lifeMapper.insertConsume(consume);
    }

    @Override
    public int editByConsume(Consume consume) {
        return lifeMapper.editByConsume(consume);
    }

    @Override
    public int delByConsumeIds(List<Integer> ids) {
        return lifeMapper.delByConsumeIds(ids);
    }

    @Override
    public Consume selectByConsumeId(Integer id) {
        return lifeMapper.selectByConsumeId(id);
    }

}
