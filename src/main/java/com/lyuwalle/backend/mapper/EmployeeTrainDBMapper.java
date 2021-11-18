package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.EmployeeTrainDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface EmployeeTrainDBMapper extends Mapper<EmployeeTrainDB>, MySqlMapper<EmployeeTrainDB> {
}