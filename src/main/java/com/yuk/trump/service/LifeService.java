package com.yuk.trump.service;

import com.yuk.trump.entity.Consume;
import com.yuk.trump.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/14 12:33
 * @description：
 * @modified By：
 */
public interface LifeService {
    /**
     * 查询消费记录
     *
     * @param paramMap
     * @return com.yuk.trump.util.PageBean<com.yuk.trump.entity.Consume>
     * @Auther: ZhixiangWang on 2019/9/15 18:54
     * @Description: TODO
     */
    PageBean<Consume> queryConsumePage(Map<String, Object> paramMap);

    /**
     * 添加消费记录
     *
     * @param consume
     * @return int
     * @Auther: ZhixiangWang on 2019/9/15 19:21
     * @Description: TODO
     */
    int insertConsume(Consume consume);

    /**
     * 修改消费记录
     *
     * @param consume
     * @return int
     * @Auther: ZhixiangWang on 2019/9/15 19:21
     * @Description: TODO
     */
    int editByConsume(Consume consume);

    /**
     * 删除消费记录
     *
     * @param ids
     * @return int
     * @Auther: ZhixiangWang on 2019/9/15 19:30
     * @Description: TODO
     */
    int delByConsumeIds(List<Integer> ids);

    /**
     * 根据Id查询消费记录
     *
     * @param id
     * @return com.yuk.trump.entity.Consume
     * @Auther: ZhixiangWang on 2019/9/15 19:07
     * @Description: TODO
     */
    Consume selectByConsumeId(Integer id);
}
