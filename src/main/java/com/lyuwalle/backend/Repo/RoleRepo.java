package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Role;
import com.lyuwalle.backend.mapper.MenuRoleDBMapper;
import com.lyuwalle.backend.mapper.RoleDBMapper;
import com.lyuwalle.backend.model.MenuRoleDB;
import com.lyuwalle.backend.model.RoleDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleRepo {

    @Autowired
    private RoleDBMapper roleDBMapper;
    @Autowired
    private MenuRoleDBMapper menuRoleDBMapper;

    public List<Role> getAllRoles() {
        return roleDBMapper.selectAll().stream().map(roleDB -> BeanCopyUtil.copy(roleDB, Role.class)).collect(Collectors.toList());
    }

    public int addRole(Role role) {
        RoleDB roleDB = new RoleDB();
        roleDB.setName("ROLE_" + role.getName());
        roleDB.setNameZh(role.getNameZh());
        return roleDBMapper.insert(roleDB);
    }

    public int deleteRoleById(Integer rid) {
        MenuRoleDB menuRoleDB = new MenuRoleDB();
        menuRoleDB.setRid(rid);
        if (menuRoleDBMapper.select(menuRoleDB).size() > 0) {
            return -1;
        }
        RoleDB roleDB = new RoleDB();
        roleDB.setId(rid);
        return roleDBMapper.delete(roleDB);
    }

    public List<Role> getRoleListByIds(List<Integer> roleIdList) {
        Example example = new Example(RoleDB.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", roleIdList);
        return roleDBMapper.selectByExample(example).stream().map(roleDB ->
                BeanCopyUtil.copy(roleDB, Role.class)).collect(Collectors.toList());
    }
}
