package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Salary;
import com.lyuwalle.backend.mapper.SalaryDBMapper;
import com.lyuwalle.backend.model.SalaryDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Lyuwalle  @date: 2021/11/24 18:28
 */
@Service
public class SalaryRepo {

    @Autowired
    private SalaryDBMapper salaryDBMapper;

    public List<Salary> getAllSalaries() {
        return salaryDBMapper.selectAll().stream().map(salaryDB -> BeanCopyUtil.copy(salaryDB, Salary.class)).collect(Collectors.toList());
    }

    public int addSalary(Salary salary) {
        return salaryDBMapper.insert(BeanCopyUtil.copy(salary, SalaryDB.class));
    }

    public int deleteSalaryById(Integer id) {
        SalaryDB salaryDB = new SalaryDB();
        salaryDB.setId(id);
        return salaryDBMapper.delete(salaryDB);
    }

    public int updateSalaryById(Salary salary) {
        SalaryDB salaryDB = BeanCopyUtil.copy(salary, SalaryDB.class);
        return salaryDBMapper.updateByPrimaryKey(salaryDB);
    }
}
