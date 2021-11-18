package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.SalaryDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SalaryDBMapper extends Mapper<SalaryDB>, MySqlMapper<SalaryDB> {
}