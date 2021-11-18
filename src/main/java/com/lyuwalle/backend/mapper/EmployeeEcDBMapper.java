package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.EmployeeEcDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface EmployeeEcDBMapper extends Mapper<EmployeeEcDB>, MySqlMapper<EmployeeEcDB> {
}