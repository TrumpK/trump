package com.yuk.trump.controller;

import com.yuk.trump.service.LifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/14 12:32
 * @description：生活点滴
 * @modified By：
 */
@Controller
@RequestMapping("trump")
public class LifeController {
    @Autowired
    LifeService lifeService;

}
