package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.HrRepo;
import com.lyuwalle.backend.domain.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    private HrRepo hrRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hrInfo = new Hr();
        hrInfo.setUsername(username);
        Hr hr = hrRepo.loadUserByUsername(hrInfo);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        return hr;
    }
}
