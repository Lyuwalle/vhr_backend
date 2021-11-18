package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.MsgContentDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MsgContentDBMapper extends Mapper<MsgContentDB>, MySqlMapper<MsgContentDB> {
}