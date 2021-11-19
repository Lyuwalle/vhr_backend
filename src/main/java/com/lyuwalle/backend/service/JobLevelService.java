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
}
