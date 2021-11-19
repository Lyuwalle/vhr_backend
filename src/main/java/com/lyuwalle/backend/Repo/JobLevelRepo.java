package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.JobLevel;
import com.lyuwalle.backend.mapper.JobLevelDBMapper;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobLevelRepo {

    @Autowired
    private JobLevelDBMapper jobLevelDbMapper;

    public List<JobLevel> getAllJobLevels() {
        return jobLevelDbMapper.selectAll().stream().map(jobLevelDb -> BeanCopyUtil.copy(jobLevelDb, JobLevel.class)).collect(Collectors.toList());
    }
}
