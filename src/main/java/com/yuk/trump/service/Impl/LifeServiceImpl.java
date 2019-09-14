package com.yuk.trump.service.Impl;

import com.yuk.trump.mapper.LifeMapper;
import com.yuk.trump.service.LifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
