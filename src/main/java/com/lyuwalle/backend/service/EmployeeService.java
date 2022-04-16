package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.*;
import com.lyuwalle.backend.common.ListResult;
import com.lyuwalle.backend.domain.Employee;
import com.lyuwalle.backend.domain.PoliticsStatus;
import com.lyuwalle.backend.utils.XlsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.lyuwalle.backend.utils.XlsUtil.hashMap;

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

    /**
     * 获取所有员工数据，用于导出
     * @return
     */
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployee = employeeRepo.getAllEmployee();
        setEmployeeConfig(allEmployee);
        return allEmployee;
    }

    private void setEmployeeConfig(List<Employee> allEmployee) {
        allEmployee.forEach(employeeEach -> {
            employeeEach.setNation(nationRepo.getNationById(employeeEach.getNationId()));
            employeeEach.setPoliticsStatus(politicsStatusRepo.getPoliticStatusById(employeeEach.getPoliticId()));
            employeeEach.setDepartment(departmentRepo.getDepartmentById(employeeEach.getDepartmentId()));
            employeeEach.setJobLevel(jobLevelRepo.getJobLevelById(employeeEach.getJobLevelId()));
            employeeEach.setPosition(positionRepo.getPositionById(employeeEach.getPosId()));
        });
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
        setEmployeeConfig(employeeList);
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

    /**
     *
     * @return
     */
    public ResponseEntity<byte[]> allEmployeeResponseEntity() throws IOException {
        List<Employee> employeeList = getAllEmployee();
        byte[] employeeByteArray = employeeListToByte(employeeList);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", new String("员工表.xls".getBytes("UTF-8"), "ISO-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(employeeByteArray, headers, HttpStatus.CREATED);
    }

    private byte[] employeeListToByte(List<Employee> employeeList) throws IOException {
        List headers = XlsUtil.generateList(
                "姓名", "性别", "生日", "身份证号码", "婚姻",
                "民族", "家乡", "政治面貌", "邮箱", "手机号码",
                "住址", "部门", "职称", "职位", "合同形式",
                "最高学历", "学校", "专业", "入职日期", "职位状态",
                "合同年限", "转正日期", "合同起始日期", "合同结束日期");

        List keys = XlsUtil.generateList(
                "name", "gender", "birthday", "idCard", "wedlock",
                "nation", "nativePlace", "politicStatus", "email", "phone",
                "address", "department", "jobLevel", "position", "engageForm",
                "tiptopDegree", "school", "specialty", "beginDate", "workState",
                "contractTerm", "conversionTime", "beginContract", "endContract"
        );
        List<Map> result = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        employeeList.forEach(employee -> {
            Map map =
                    hashMap(
                            "name", employee.getName(),
                            "gender", employee.getGender(),
                            "birthday", simpleDateFormat.format(employee.getBirthday()),
                            "idCard", employee.getIdCard(),
                            "wedlock", employee.getWedlock(),
                            "nation", employee.getNation().getName(),
                            "nativePlace", employee.getNativePlace(),
                            "politicStatus", employee.getPoliticsStatus().getName(),
                            "email", employee.getEmail(),
                            "phone", employee.getPhone(),
                            "address", employee.getAddress(),
                            "department", employee.getDepartment().getName(),
                            "jobLevel", employee.getJobLevel().getName(),
                            "position", employee.getPosition().getName(),
                            "engageForm", employee.getEngageForm(),
                            "tiptopDegree", employee.getTiptopDegree(),
                            "school", employee.getSchool(),
                            "specialty", employee.getSpecialty(),
                            "beginDate", simpleDateFormat.format(employee.getBeginDate()),
                            "workState", employee.getWorkState(),
                            "contractTerm", employee.getContractTerm(),
                            "conversionTime", simpleDateFormat.format(employee.getConversionTime()),
                            "beginContract", simpleDateFormat.format(employee.getBeginContract()),
                            "endContract", simpleDateFormat.format(employee.getEndContract())
                    );
            result.add(map);
        });
        return XlsUtil.createXlsByte(headers, keys, result);
    }
}
