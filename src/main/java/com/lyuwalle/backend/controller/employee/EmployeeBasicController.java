package com.lyuwalle.backend.controller.employee;

import com.lyuwalle.backend.common.ListResult;
import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.domain.*;
import com.lyuwalle.backend.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author lyuxiyang
 * @TODO 上传下载
 */
@Slf4j
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
     * @param page
     * @param pageSize
     * @param employee 根据员工姓名进行搜索放在了employee的name属性里面
     * @param beginDateScope 入职日期的范围
     * @return
     */
    @GetMapping("/allEmp")
    public ListResult<Employee> getAllEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                                     Employee employee, String[] beginDateScope) throws ParseException {
        log.info("分页查询员工信息，查询条件: employee = {}, {}", employee, beginDateScope);
        return employeeService.getAllEmployeeByPage(page, pageSize, employee, beginDateScope);
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
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpById(@PathVariable Integer id) {
        if (employeeService.deleteEmpById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @GetMapping("/maxEmpId")
    public String getMaxEmpId() {
        return String.format("%08d", employeeService.getMaxEmpId() + 1);
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

    /**
     * 导出所有员工的数据
     * @return
     * @throws IOException
     */
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() throws IOException {
        /*首先去数据库里面查询出所有的员工数据，然后返回*/
        return employeeService.allEmployeeResponseEntity();
    }

    /**
     * 导入数据
     * @param file 表示前端上传的文件
     * @return
     * @throws IOException
     */
    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
/*        file.transferTo(new File("/Users/lyuxiyang/Downloads/vhr上传文件"));
        return RespBean.ok("上传成功");*/
        List<Employee> employeeList = employeeService.employeeFileToContent(file);
        if(employeeService.addEmployeeList(employeeList) == employeeList.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("excel解析失败");
    }

}
