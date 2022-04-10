package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.*;
import com.lyuwalle.backend.common.ListResult;
import com.lyuwalle.backend.domain.Employee;
import com.lyuwalle.backend.domain.PoliticsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lyuxiyang
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private NationRepo nationRepo;
    @Autowired
    private PoliticsStatusRepo politicsStatusRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private JobLevelRepo jobLevelRepo;
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private SalaryRepo salaryRepo;

    public ListResult<Employee> getEmployeeByPage(Integer page, Integer pageSize, Employee employee, Date[] dateScope) {
        return employeeRepo.getEmployeeByPage(page, pageSize, employee, dateScope);
    }

    public ListResult<Employee> getAllEmployeeByPage(Integer page, Integer pageSize, String keyword) {
        //设置民族，政治面貌，职位等信息
        ListResult<Employee> employeeListResult = employeeRepo.getAllEmployeeByPage(page, pageSize, keyword);
        List<Employee> employeeList = employeeListResult.getRecords();
        employeeList.forEach(employee -> {
            employee.setNation(nationRepo.getNationById(employee.getNationId()));
            employee.setPoliticsStatus(politicsStatusRepo.getPoliticStatusById(employee.getPoliticId()));
            employee.setDepartment(departmentRepo.getDepartmentById(employee.getDepartmentId()));
            employee.setJobLevel(jobLevelRepo.getJobLevelById(employee.getJobLevelId()));
            employee.setPosition(positionRepo.getPositionById(employee.getPosId()));
            //employee.setSalary(salaryRepo.);
        });
        employeeListResult.setRecords(employeeList);
        return employeeListResult;
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
