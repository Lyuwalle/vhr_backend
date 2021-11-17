package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.HrDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface HrDBMapper extends Mapper<HrDB>, MySqlMapper<HrDB> {
}