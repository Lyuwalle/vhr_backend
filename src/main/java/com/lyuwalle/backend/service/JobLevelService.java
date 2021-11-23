package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.JobLevelRepo;
import com.lyuwalle.backend.domain.JobLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyuxiyang
 */
@Service
public class JobLevelService {

    @Autowired
    private JobLevelRepo jobLevelRepo;

    public List<JobLevel> getAllJobLevels() {
        return jobLevelRepo.getAllJobLevels();
    }

    public int addJobLevel(JobLevel jobLevel) {
        return jobLevelRepo.addJobLevel(jobLevel);
    }

    public int updateJobLevel(JobLevel jobLevel) {
        return jobLevelRepo.updateJobLevel(jobLevel);
    }

    public int deleteJobLevelById(Integer id) {
        return jobLevelRepo.deleteJobLevelById(id);
    }

    public int deleteJobLevelByIds(Integer[] ids) {
        return jobLevelRepo.deleteJobLevelByIds(ids);
    }
}
