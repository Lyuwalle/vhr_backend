package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.MenuDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MenuDBMapper extends Mapper<MenuDB>, MySqlMapper<MenuDB> {
}