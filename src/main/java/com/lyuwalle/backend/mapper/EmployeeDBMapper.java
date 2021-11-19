package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.EmployeeDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface EmployeeDBMapper extends Mapper<EmployeeDB>, MySqlMapper<EmployeeDB> {
    /**
     * 获取当前数据库中的最大的workID
     * @return
     */
    int getMaxEmpId();
}