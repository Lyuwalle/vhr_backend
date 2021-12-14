package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.HrRepo;
import com.lyuwalle.backend.Repo.HrRoleRepo;
import com.lyuwalle.backend.domain.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    private HrRepo hrRepo;

    @Autowired
    private HrRoleRepo hrRoleRepo;
    
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
        return hrRepo.getAllHrs(keywords);
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
