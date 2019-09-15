package com.yuk.trump.mapper;

import com.yuk.trump.entity.Admin;
import com.yuk.trump.entity.Consume;

import java.util.List;
import java.util.Map;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/14 12:34
 * @description：
 * @modified By：
 */
public interface LifeMapper {
    /**
     * 查询消费记录
     *
     * @param paramMap
     * @return java.util.List<com.yuk.trump.entity.Consume>
     * @Auther: ZhixiangWang on 2019/9/15 18:55
     * @Description: TODO
     */
    List<Consume> queryConsumeList(Map<String, Object> paramMap);

    /**
     * 查询消费记录总条数
     *
     * @param paramMap
     * @return java.lang.Integer
     * @Auther: ZhixiangWang on 2019/9/15 18:55
     * @Description: TODO
     */
    Integer queryConsumeCount(Map<String, Object> paramMap);

    /**
     * 添加消费记录
     *
     * @param consume
     * @return int
     * @Auther: ZhixiangWang on 2019/9/15 19:20
     * @Description: TODO
     */
    int insertConsume(Consume consume);

    /**
     * 修改消费记录
     *
     * @param consume
     * @return int
     * @Auther: ZhixiangWang on 2019/9/15 19:20
     * @Description: TODO
     */
    int editByConsume(Consume consume);

    /**
     * 删除消费记录
     *
     * @param ids
     * @return int
     * @Auther: ZhixiangWang on 2019/9/15 19:29
     * @Description: TODO
     */
    int delByConsumeIds(List<Integer> ids);

    /**
     * 根据Id查询消费记录
     *
     * @param id
     * @return com.yuk.trump.entity.Consume
     * @Auther: ZhixiangWang on 2019/9/15 19:04
     * @Description: TODO
     */
    Consume selectByConsumeId(Integer id);


}
