package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.NationDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface NationDBMapper extends Mapper<NationDB>, MySqlMapper<NationDB> {
}