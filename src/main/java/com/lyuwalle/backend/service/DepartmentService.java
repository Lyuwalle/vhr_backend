package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.DepartmentRepo;
import com.lyuwalle.backend.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lyuxiyang
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> getAllDepartments() {
        List<Department> allDepartments = departmentRepo.getAllDepartments();
        return allDepartments.stream().map(department -> {
            if(department.getIsParent()) {
                List<Department> childrenDepartments = departmentRepo.getChildDepartmentsById(department.getId());
                department.setChildren(childrenDepartments);
            }
            return department;
        }).collect(Collectors.toList());
    }
}
