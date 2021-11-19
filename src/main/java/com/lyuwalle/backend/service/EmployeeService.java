package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.EmployeeRepo;
import com.lyuwalle.backend.common.ListResult;
import com.lyuwalle.backend.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lyuxiyang
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public ListResult<Employee> getEmployeeByPage(Integer page, Integer pageSize, Employee employee, Date[] dateScope) {
        return employeeRepo.getEmployeeByPage(page, pageSize, employee, dateScope);
    }

    public int addEmployee(Employee employee) {
        return employeeRepo.addEmployee(employee);
    }

    public int updateEmployee(Employee employee) {
        return employeeRepo.updateEmployee(employee);
    }

    public int deleteEmpById(Integer id) {
        return employeeRepo.deleteEmpById(id);
    }

    public int getMaxEmpId() {
        return employeeRepo.getMaxEmpId();
    }
}
