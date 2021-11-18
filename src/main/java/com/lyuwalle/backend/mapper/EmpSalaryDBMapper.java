package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.EmpSalaryDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface EmpSalaryDBMapper extends Mapper<EmpSalaryDB>, MySqlMapper<EmpSalaryDB> {
}