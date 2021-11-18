package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.JobLevelDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface JobLevelDBMapper extends Mapper<JobLevelDB>, MySqlMapper<JobLevelDB> {
}