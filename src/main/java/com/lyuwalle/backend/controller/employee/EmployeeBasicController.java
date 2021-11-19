package com.lyuwalle.backend.controller.employee;

import com.lyuwalle.backend.common.ListResult;
import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.domain.*;
import com.lyuwalle.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author lyuxiyang
 * @TODO 上传下载
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeBasicController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private NationService nationService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private JobLevelService jobLevelService;
    @Autowired
    private PoliticStatusService politicStatusService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询所有员工资料
     *
     * @param page
     * @param pageSize
     * @param employee
     * @param dateScope 表示入职日期的范围
     * @return
     */
    @GetMapping("/")
    public ListResult<Employee> getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        Employee employee, Date[] dateScope) {
        return employeeService.getEmployeeByPage(page, pageSize, employee, dateScope);
    }

    /**
     * 添加员工
     *
     * @param employee
     * @return
     */
    @PostMapping("/")
    public RespBean addEmployee(@RequestBody  Employee employee) {
        if (employeeService.addEmployee(employee) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 更新员工信息
     *
     * @param employee
     * @return
     */
    @PutMapping("/")
    public RespBean updateEmployee(@RequestBody Employee employee) {
        if (employeeService.updateEmployee(employee) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpById(@PathVariable Integer id) {
        if (employeeService.deleteEmpById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @GetMapping("/maxEmpId")
    public RespBean getMaxEmpId() {
        return RespBean.build().setStatus(200).setObject(String.format("%08d", employeeService.getMaxEmpId() + 1));
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/politicsStatuses")
    public List<PoliticsStatus> getAllPoliticStatuses() {
        return politicStatusService.getAllPoliticStatuses();
    }

    @GetMapping("/jobLevels")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

}
