package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.DepartmentRepo;
import com.lyuwalle.backend.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyuxiyang
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> getAllDepartments() {
        return departmentRepo.getAllDepartments();
    }
}
