package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Department;
import com.lyuwalle.backend.mapper.DepartmentDBMapper;
import com.lyuwalle.backend.model.DepartmentDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentRepo {

    @Autowired
    private DepartmentDBMapper departmentDBMapper;

    public List<Department> getAllDepartments() {
        List<DepartmentDB> departmentDbList = departmentDBMapper.selectAll();
        return departmentDbList.stream().map(departmentDB -> BeanCopyUtil.copy(departmentDB, Department.class)).collect(Collectors.toList());
    }
}