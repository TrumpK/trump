package com.yuk.trump.controller;

import com.yuk.trump.entity.Admin;
import com.yuk.trump.entity.Consume;
import com.yuk.trump.service.LifeService;
import com.yuk.trump.util.AjaxResult;
import com.yuk.trump.util.Data;
import com.yuk.trump.util.DateUtil;
import com.yuk.trump.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private AjaxResult ajaxResult;

    /**
     * 跳转消费记录页面
     *
     * @return
     */
    @GetMapping("/consum")
    public String consum() {
        return "manager/consum/consumList";
    }

    /**
     * 异步加载消费记录列表
     *
     * @param pageno
     * @param pagesize
     * @return java.lang.Object
     * @Auther: ZhixiangWang on 2019/9/15 18:51
     * @Description: TODO
     */
    @RequestMapping("/consumeList")
    @ResponseBody
    public Object consumeList(@RequestParam(value = "page", defaultValue = "1") Integer pageno,
                              @RequestParam(value = "limit", defaultValue = "5") Integer pagesize) {
        Map<String, Object> paramMap = new HashMap<String, Object>(16);
        paramMap.put("pageno", pageno);
        paramMap.put("pagesize", pagesize);
        PageBean<Consume> pageBean = lifeService.queryConsumePage(paramMap);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", pageBean.getTotalsize());
        result.put("data", pageBean.getDatas());
        return result;
    }



    /**
     * 添加或修改消费记录
     *
     * @param consume
     * @return com.yuk.trump.util.AjaxResult
     * @Auther: ZhixiangWang on 2019/9/15 19:25
     * @Description: TODO
     */
    @PostMapping("/addConsumeList")
    @ResponseBody
    public AjaxResult submitAddConsumeList(Consume consume) {
        if (consume.getId() != null) {
            int count = lifeService.editByConsume(consume);
            if (count > 0) {
                ajaxResult.ajaxTrue("修改成功");
            } else {
                ajaxResult.ajaxFalse("修改失败");
            }
        } else {
            int count = lifeService.insertConsume(consume);
            if (count > 0) {
                ajaxResult.ajaxTrue("添加成功");
            } else {
                ajaxResult.ajaxFalse("添加失败");
            }
        }
        return ajaxResult;
    }


    @PostMapping("/delConsumeList")
    @ResponseBody
    public AjaxResult delConsumeList(Data data){
        int count = lifeService.delByConsumeIds(data.getIds());
        if(count >= data.getIds().size()){
            ajaxResult.ajaxTrue("删除成功");
        }else{
            ajaxResult.ajaxFalse("删除失败");
        }
        return ajaxResult;
    }
}
