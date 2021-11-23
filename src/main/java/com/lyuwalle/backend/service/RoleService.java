package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.RoleRepo;
import com.lyuwalle.backend.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<Role> getAllRoles() {
        return roleRepo.getAllRoles();
    }

    public int addRole(Role role) {
        return roleRepo.addRole(role);
    }

    public int deleteRoleById(Integer rid) {
        return roleRepo.deleteRoleById(rid);
    }
}
