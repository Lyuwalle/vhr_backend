package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.mapper.HrDBMapper;
import com.lyuwalle.backend.model.HrDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrRepo {

    @Autowired
    private HrDBMapper hrDBMapper;

    public Hr loadUserByUsername(Hr hrInfo) {
        HrDB hrDB = BeanCopyUtil.copy(hrInfo, HrDB.class);
        HrDB hrDB1 = hrDBMapper.selectOne(hrDB);
        return BeanCopyUtil.copy(hrDB1, Hr.class);
    }
}
