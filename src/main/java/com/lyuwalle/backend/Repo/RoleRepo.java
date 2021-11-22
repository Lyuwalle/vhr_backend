package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Role;
import com.lyuwalle.backend.mapper.RoleDBMapper;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleRepo {

    @Autowired
    private RoleDBMapper roleDBMapper;

    public List<Role> getAllRoles() {
        return roleDBMapper.selectAll().stream().map(roleDB -> BeanCopyUtil.copy(roleDB, Role.class)).collect(Collectors.toList());
    }
}
