package com.lyuwalle.backend.mapper;

import com.lyuwalle.backend.model.MailSendLogDB;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MailSendLogDBMapper extends Mapper<MailSendLogDB>, MySqlMapper<MailSendLogDB> {
}