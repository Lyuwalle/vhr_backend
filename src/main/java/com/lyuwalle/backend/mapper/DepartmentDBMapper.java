package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.DepartmentDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface DepartmentDBMapper extends Mapper<DepartmentDB>, MySqlMapper<DepartmentDB> {

    Integer selectMaxId();
}