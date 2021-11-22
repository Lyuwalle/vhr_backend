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

@Controller
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("update successfully!");
        }
        return RespBean.error("update failed!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if(hrService.deleteHrById(id) == 1) {
            return RespBean.ok("delete successfully!");
        }
        return RespBean.error("delete failed!");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole (Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("update successfully!");
        }
        return RespBean.error("update failed!");
    }



}
