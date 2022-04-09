package com.lyuwalle.backend.controller.system;

import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.domain.Role;
import com.lyuwalle.backend.service.HrService;
import com.lyuwalle.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    /**
     * 获取所有用户信息（除了当前登录的用户）
     * @param keywords
     * @return
     */
    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新用户成功");
        }
        return RespBean.error("更新用户失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if(hrService.deleteHrById(id) == 1) {
            return RespBean.ok("删除用户成功");
        }
        return RespBean.error("删除用户失败");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole (Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("更新用户角色成功");
        }
        return RespBean.error("更新用户角色失败");
    }



}
