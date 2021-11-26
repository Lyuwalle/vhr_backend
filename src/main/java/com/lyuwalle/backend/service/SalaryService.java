package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.SalaryRepo;
import com.lyuwalle.backend.domain.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Lyuwalle  @date: 2021/11/24 18:27
 */
@Service
public class SalaryService {

    @Autowired
    private SalaryRepo salaryRepo;

    public List<Salary> getAllSalaries() {
        return salaryRepo.getAllSalaries();
    }

    public int addSalary(Salary salary) {
        return salaryRepo.addSalary(salary);
    }

    public int deleteSalaryById(Integer id) {
        return salaryRepo.deleteSalaryById(id);
    }

    public int updateSalaryById(Salary salary) {
        return salaryRepo.updateSalaryById(salary);
    }
}
