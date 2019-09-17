package com.yuk.trump.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/17 21:08
 * @description：
 * @modified By：
 */
@Controller
@RequestMapping("/trump")
public class Util {
    @GetMapping("/getPlace")
    public String getPlace(){
        return "manager/common/map";
    }
}
