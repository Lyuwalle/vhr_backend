package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.domain.Role;
import com.lyuwalle.backend.mapper.HrDBMapper;
import com.lyuwalle.backend.mapper.HrRoleDBMapper;
import com.lyuwalle.backend.mapper.RoleDBMapper;
import com.lyuwalle.backend.model.HrDB;
import com.lyuwalle.backend.model.HrRoleDB;
import com.lyuwalle.backend.model.RoleDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import com.lyuwalle.backend.utils.HrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HrRepo {

    @Autowired
    private HrDBMapper hrDBMapper;
    @Autowired
    private HrRoleDBMapper hrRoleDBMapper;
    @Autowired
    private RoleDBMapper roleDBMapper;

    public Hr loadUserByUsername(Hr hrInfo) {
        HrDB hrDB = new HrDB();
        hrDB.setUsername(hrInfo.getUsername());
        return BeanCopyUtil.copy(hrDBMapper.selectOne(hrDB), Hr.class);
    }

    public List<Hr> getAllHrs(String keywords) {
        //获得当前登录的hr，作为过滤
        Integer currentHrId = HrUtil.getCurrentHr().getId();

        Example example = new Example(HrDB.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", keywords);
        List<HrDB> hrDBS = hrDBMapper.selectByExample(example);
        return hrDBS.stream().filter(hrDB -> !hrDB.getId().equals(currentHrId))
                .map(hrDB -> BeanCopyUtil.copy(hrDB, Hr.class)).collect(Collectors.toList());
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

    public List<Role> getHrRolesById(Integer hrId) {
        HrRoleDB hrRoleDB = new HrRoleDB();
        hrRoleDB.setHrid(hrId);
        List<HrRoleDB> hrRoleList = hrRoleDBMapper.select(hrRoleDB);
        List<Role> roles = new ArrayList<>();
        for (HrRoleDB hrRoleDB1 : hrRoleList) {
            Integer rid = hrRoleDB1.getRid();
            RoleDB roleDB = new RoleDB();
            roleDB.setId(rid);
            RoleDB roleDB1 = roleDBMapper.selectOne(roleDB);
            roles.add(BeanCopyUtil.copy(roleDB1, Role.class));
        }
        return roles;
    }
}
