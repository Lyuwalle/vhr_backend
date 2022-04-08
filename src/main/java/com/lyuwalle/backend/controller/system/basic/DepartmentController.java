package com.lyuwalle.backend.controller.system.basic;

import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.domain.Department;
import com.lyuwalle.backend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyuxiyang
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    /**
     * 添加新部门：需要的参数：parentID，name
     * @param department
     */
    @PostMapping("/")
    public RespBean addDepartment(@RequestBody Department department) {
        if (departmentService.addDepartment(department) == 1) {
            return RespBean.ok("添加部门成功", department);
        }
        return RespBean.error("添加部门失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepartmentById(@PathVariable Integer id) {
        if (departmentService.deleteDepartmentById(id) == 1) {
            return RespBean.ok("删除部门成功");
        } else {
            return RespBean.error("删除部门失败");
        }
    }


}
