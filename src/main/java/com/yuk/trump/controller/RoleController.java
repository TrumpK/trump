package com.yuk.trump.controller;

import com.yuk.trump.entity.Role;
import com.yuk.trump.service.RoleService;
import com.yuk.trump.util.AjaxResult;
import com.yuk.trump.util.Const;
import com.yuk.trump.util.Data;
import com.yuk.trump.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 13:04
 * @description：RoleController
 * @modified By：
 */
@Controller
@RequestMapping("/trump")
public class RoleController {
    @Autowired
    private AjaxResult ajaxResult;
    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    public String role(){
        return "manager/role/roleList";
    }

    /**
     * 异步加载角色列表
     * @param pageno
     * @param pagesize
     * @param rid
     * @return
     */
    @RequestMapping("/roleList")
    @ResponseBody
    public Object roleList(@RequestParam(value = "page", defaultValue = "1") Integer pageno,
                           @RequestParam(value = "limit", defaultValue = "5") Integer pagesize,
                           String rid){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",pageno);
        paramMap.put("pagesize",pagesize);

        //判断是否为空
        if(!StringUtils.isEmpty(rid) && !rid.equals("0")) paramMap.put("rid",rid);

        PageBean<Role> pageBean = roleService.queryPage(paramMap);

        Map<String,Object> rest = new HashMap();
        rest.put("code", 0);
        rest.put("msg", "");
        rest.put("count",pageBean.getTotalsize());
        rest.put("data", pageBean.getDatas());
        return rest;
    }


    /**
     * 删除角色
     * @param data
     * @return
     */
    @PostMapping("/delRole")
    @ResponseBody
    public AjaxResult delRole(Data data){
        int count = roleService.delByRoleIds(data.getIds());
        if(count >= data.getIds().size()){
            ajaxResult.ajaxTrue("删除成功");
        }else{
            ajaxResult.ajaxFalse("存在管理员拥有此角色,无法删除");
        }
        return ajaxResult;
    }

    /**
     * 跳转添加角色页面
     * @param type
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/addRole")
    public String addRole(String type, Integer id, Model model){
        if(type != null && type.equals("edit")){
            Role role = roleService.selectById(id);
            model.addAttribute(Const.ROLE,role);
        }
        return "manager/role/addRole";
    }


    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    @ResponseBody
    public AjaxResult submitAddRole(Role role){
        Role byName = roleService.selectByName(role.getName());
        if(role.getId() !=null){
            //修改角色
            if(byName != null && !byName.getId().equals(role.getId())){
                //与修改角色一样，但存在数据库中，表示后来改的角色已存在
                ajaxResult.ajaxFalse("角色已存在");
                return ajaxResult;
            }
            int count = roleService.editByRole(role);
            if(count > 0){
                ajaxResult.ajaxTrue("修改成功");
            }else{
                ajaxResult.ajaxFalse("修改失败");
            }
        }else{
            //添加角色
            if(byName != null){
                //与原角色不一样，但存在数据库中，表示后来改的角色已存在
                ajaxResult.ajaxFalse("角色已存在");
                return ajaxResult;
            }
            int count = roleService.insertRole(role);
            if(count > 0){
                ajaxResult.ajaxTrue("添加成功");
            }else{
                ajaxResult.ajaxFalse("添加失败");
            }
        }
        return ajaxResult;
    }

    @GetMapping("/allotPer")
    public String allotPer(Integer id,Model model){
        model.addAttribute("id",id);
        return "/manager/role/allotPer";
    }
}
