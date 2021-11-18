package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.PoliticsStatusDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PoliticsStatusDBMapper extends Mapper<PoliticsStatusDB>, MySqlMapper<PoliticsStatusDB> {
}