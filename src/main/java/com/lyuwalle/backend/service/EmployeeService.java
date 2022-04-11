package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.*;
import com.lyuwalle.backend.common.ListResult;
import com.lyuwalle.backend.domain.Employee;
import com.lyuwalle.backend.domain.PoliticsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public ListResult<Employee> getAllEmployeeByPage(Integer page, Integer pageSize, Employee employee, String[] beginDateScope) throws ParseException {
        Date[] dateScope = null;
        if (Objects.nonNull(beginDateScope)) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateScope = new Date[]{dateFormat.parse(beginDateScope[0]), dateFormat.parse(beginDateScope[1])};
        }
        //设置民族，政治面貌，职位等信息
        ListResult<Employee> employeeListResult = employeeRepo.getAllEmployeeByPage(page, pageSize, employee, dateScope);
        List<Employee> employeeList = employeeListResult.getRecords();
        employeeList.forEach(employeeEach -> {
            employeeEach.setNation(nationRepo.getNationById(employeeEach.getNationId()));
            employeeEach.setPoliticsStatus(politicsStatusRepo.getPoliticStatusById(employeeEach.getPoliticId()));
            employeeEach.setDepartment(departmentRepo.getDepartmentById(employeeEach.getDepartmentId()));
            employeeEach.setJobLevel(jobLevelRepo.getJobLevelById(employeeEach.getJobLevelId()));
            employeeEach.setPosition(positionRepo.getPositionById(employeeEach.getPosId()));
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
