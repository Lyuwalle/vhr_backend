package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.RoleDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface RoleDBMapper extends Mapper<RoleDB>, MySqlMapper<RoleDB> {
}