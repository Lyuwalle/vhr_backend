package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.mapper.HrDBMapper;
import com.lyuwalle.backend.model.HrDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HrRepo {

    @Autowired
    private HrDBMapper hrDBMapper;

    public Hr loadUserByUsername(Hr hrInfo) {
        HrDB hrDB = new HrDB();
        hrDB.setUsername(hrInfo.getUsername());
        return BeanCopyUtil.copy(hrDBMapper.selectOne(hrDB), Hr.class);
    }

    public List<Hr> getAllHrs(String keywords) {
        Example example = new Example(HrDB.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", keywords);
        List<HrDB> hrDBS = hrDBMapper.selectByExample(example);
        return hrDBS.stream().map(hrDB -> BeanCopyUtil.copy(hrDB, Hr.class)).collect(Collectors.toList());
    }

    public int updateHr(Hr hr) {
        HrDB hrDB = BeanCopyUtil.copy(hr, HrDB.class);
        return hrDBMapper.updateByPrimaryKey(hrDB);
    }

    public int deleteHrById(Integer id) {
        HrDB hrDB = new HrDB();
        hrDB.setId(id);
        return hrDBMapper.delete(hrDB);
    }

}
