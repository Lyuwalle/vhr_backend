package com.lyuwalle.backend.Repo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyuwalle.backend.common.ListResult;
import com.lyuwalle.backend.domain.Employee;
import com.lyuwalle.backend.mapper.EmployeeDBMapper;
import com.lyuwalle.backend.model.EmployeeDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lyuxiyang
 */
@Service
public class EmployeeRepo {

    @Autowired
    private EmployeeDBMapper employeeDBMapper;

    public List<Employee> getAllEmployee() {
        return employeeDBMapper.selectAll().stream().map(employeeDB ->
                BeanCopyUtil.copy(employeeDB, Employee.class)).collect(Collectors.toList());
    }

    public ListResult<Employee> getAllEmployeeByPage(Integer page, Integer pageSize, Employee employee, Date[] dateScope) {
        Page<EmployeeDB> employeeDbList = PageHelper.startPage(page, pageSize).doSelectPage(() -> {
            Example example = new Example(EmployeeDB.class);
            Example.Criteria criteria = example.createCriteria();
            if (Objects.nonNull(employee)) {
                criteria.andEqualTo("politicId", employee.getPoliticId())
                        .andEqualTo("nationId", employee.getNationId())
                        .andEqualTo("jobLevelId", employee.getJobLevelId())
                        .andEqualTo("posId", employee.getPosId())
                        .andEqualTo("engageForm", employee.getEngageForm())
                        .andEqualTo("departmentId", employee.getDepartmentId());
            }
            if (Objects.nonNull(dateScope)) {
                criteria.andGreaterThanOrEqualTo("beginDate", dateScope[0])
                        .andLessThanOrEqualTo("beginDate", dateScope[1]);
            }
            if (employee.getName() != null && !employee.getName().equals("")) {
                criteria.andLike("name", "%" + employee.getName() + "%");
            }
            employeeDBMapper.selectByExample(example);
        });
        List<Employee> employeeList = employeeDbList.stream().map(employeeDB -> BeanCopyUtil.copy(employeeDB, Employee.class)).collect(Collectors.toList());
        return new ListResult<>(employeeDbList.getTotal(), employeeList);
    }

    public int addEmployee(Employee employee) {
        EmployeeDB employeeDB = BeanCopyUtil.copy(employee, EmployeeDB.class);
        return employeeDBMapper.insert(employeeDB);
    }

    public int updateEmployee(Employee employee) {
        EmployeeDB employeeDB = BeanCopyUtil.copy(employee, EmployeeDB.class);
        return employeeDBMapper.updateByPrimaryKey(employeeDB);
    }

    public int deleteEmpById(Integer id) {
        EmployeeDB employeeDB = new EmployeeDB();
        employeeDB.setId(id);
        return employeeDBMapper.deleteByPrimaryKey(employeeDB);
    }

    public int getMaxEmpId() {
        return employeeDBMapper.getMaxEmpId();
    }

}
