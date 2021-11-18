package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.OplogDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface OplogDBMapper extends Mapper<OplogDB>, MySqlMapper<OplogDB> {
}