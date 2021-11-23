package com.lyuwalle.backend.controller.system.basic;

import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.domain.Department;
import com.lyuwalle.backend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }


}
