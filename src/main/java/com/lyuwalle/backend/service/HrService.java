package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.HrRepo;
import com.lyuwalle.backend.Repo.HrRoleRepo;
import com.lyuwalle.backend.Repo.RoleRepo;
import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.domain.HrRole;
import com.lyuwalle.backend.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    private HrRepo hrRepo;
    @Autowired
    private HrRoleRepo hrRoleRepo;
    @Autowired
    private RoleRepo roleRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hrInfo = new Hr();
        hrInfo.setUsername(username);
        Hr hr = hrRepo.loadUserByUsername(hrInfo);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        //登录成功之后设置用户的角色
        hr.setRoles(hrRepo.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        List<Hr> allHrs = hrRepo.getAllHrs(keywords);
        allHrs.forEach(hr -> {
            if (hr.isEnabled()) {
                Integer hrId = hr.getId();
                List<HrRole> hrRoleList = hrRoleRepo.getHrRoleListByHrId(hrId);
                List<Integer> roleIdList = hrRoleList.stream().map(hrRole -> hrRole.getRid()).collect(Collectors.toList());
                List<Role> roleList = roleRepo.getRoleListByIds(roleIdList);
                hr.setRoles(roleList);
            }
        });
        return allHrs;
    }

    public int updateHr(Hr hr) {
        return hrRepo.updateHr(hr);
    }

    public int deleteHrById(Integer id) {
        return hrRepo.deleteHrById(id);
    }

    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        return hrRoleRepo.updateHrRole(hrid, rids);
    }
}
