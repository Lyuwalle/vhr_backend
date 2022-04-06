package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.MenuRole;
import com.lyuwalle.backend.mapper.MenuRoleDBMapper;
import com.lyuwalle.backend.model.MenuRoleDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Lyuwalle  @date: 2022/04/07 00:39
 */

@Service
public class MenuRoleRepo {

    @Autowired
    private MenuRoleDBMapper menuRoleDBMapper;

    public void deleteMenuRoleByRid(Integer rid) {
        MenuRoleDB menuRoleDB = new MenuRoleDB();
        menuRoleDB.setRid(rid);
        menuRoleDBMapper.delete(menuRoleDB);
    }

    public Integer addMenuRole(MenuRole menuRole) {
        MenuRoleDB menuRoleDB = BeanCopyUtil.copy(menuRole, MenuRoleDB.class);
        return menuRoleDBMapper.insert(menuRoleDB);
    }
}
