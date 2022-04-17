package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Employee;
import com.lyuwalle.backend.domain.JobLevel;
import com.lyuwalle.backend.mapper.EmployeeDBMapper;
import com.lyuwalle.backend.mapper.JobLevelDBMapper;
import com.lyuwalle.backend.model.AdjustSalaryDB;
import com.lyuwalle.backend.model.EmployeeDB;
import com.lyuwalle.backend.model.JobLevelDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobLevelRepo {

    @Autowired
    private JobLevelDBMapper jobLevelDbMapper;
    @Autowired
    private EmployeeDBMapper employeeDBMapper;

    public List<JobLevel> getAllJobLevels() {
        return jobLevelDbMapper.selectAll().stream().map(jobLevelDb -> BeanCopyUtil.copy(jobLevelDb, JobLevel.class)).collect(Collectors.toList());
    }

    public int addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        return jobLevelDbMapper.insert(BeanCopyUtil.copy(jobLevel, JobLevelDB.class));
    }

    public int updateJobLevel(JobLevel jobLevel) {
        return jobLevelDbMapper.updateByPrimaryKeySelective(BeanCopyUtil.copy(jobLevel, JobLevelDB.class));
    }

    public int deleteJobLevelById(Integer id) {
        EmployeeDB employeeDB = new EmployeeDB();
        employeeDB.setJobLevelId(id);
        List<EmployeeDB> employeeDBS = employeeDBMapper.select(employeeDB);
        if (employeeDBS.size() > 0) {
            return -1;
        }
        JobLevelDB jobLevelDB = new JobLevelDB();
        jobLevelDB.setId(id);
        return jobLevelDbMapper.delete(jobLevelDB);
    }

    public int deleteJobLevelByIds(Integer[] ids) {
        for (Integer id : ids) {
            EmployeeDB employeeDB = new EmployeeDB();
            employeeDB.setJobLevelId(id);
            List<EmployeeDB> employeeDBS = employeeDBMapper.select(employeeDB);
            if (employeeDBS.size() > 0) {
                return -1;
            }
        }
        int result = 0;
        for (Integer id : ids) {
            JobLevelDB jobLevelDB = new JobLevelDB();
            jobLevelDB.setId(id);
            result += jobLevelDbMapper.delete(jobLevelDB);
        }
        return result;
    }

    public JobLevel getJobLevelById(Integer jobLevelId) {
        JobLevelDB jobLevelDB = new JobLevelDB();
        jobLevelDB.setId(jobLevelId);
        return BeanCopyUtil.copy(jobLevelDbMapper.selectByPrimaryKey(jobLevelDB), JobLevel.class);
    }

    public JobLevel getJobLevelByName(String name) {
        JobLevelDB jobLevelDB = new JobLevelDB();
        jobLevelDB.setName(name);
        return BeanCopyUtil.copy(jobLevelDbMapper.selectOne(jobLevelDB), JobLevel.class);
    }
}
