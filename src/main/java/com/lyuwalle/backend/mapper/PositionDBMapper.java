package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.PositionDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PositionDBMapper extends Mapper<PositionDB>, MySqlMapper<PositionDB> {
}