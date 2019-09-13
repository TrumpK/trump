package com.yuk.trump.service.Impl;

import com.yuk.trump.entity.Icon;
import com.yuk.trump.mapper.IconMapper;
import com.yuk.trump.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:09
 * @description：IconServiceImpl
 * @modified By：
 */
@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconMapper iconMapper;

    @Override
    public List<Icon> selectAll() {
        return iconMapper.selectAll();
    }
}
