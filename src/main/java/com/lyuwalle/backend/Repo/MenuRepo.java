package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.domain.Menu;
import com.lyuwalle.backend.domain.Role;
import com.lyuwalle.backend.mapper.MenuDBMapper;
import com.lyuwalle.backend.mapper.MenuRoleDBMapper;
import com.lyuwalle.backend.model.MenuRoleDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import com.lyuwalle.backend.utils.HrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuRepo {

    @Autowired
    private MenuDBMapper menuDBMapper;
    @Autowired
    private MenuRoleDBMapper menuRoleDBMapper;


    public List<Menu> getAllMenus() {
        return menuDBMapper.selectAll().stream().map(menuDB -> BeanCopyUtil.copy(menuDB, Menu.class)).collect(Collectors.toList());
    }

    public List<Integer> getMidsByRid(Integer rid) {
        MenuRoleDB menuRoleDB = new MenuRoleDB();
        menuRoleDB.setRid(rid);
        return menuRoleDBMapper.select(menuRoleDB).stream().map(MenuRoleDB::getMid).collect(Collectors.toList());
    }

    /**
     * 获取当前登录用户展示的菜单
     *
     * @return
     */
    public List<Menu> getMenusByHrId() {
        Hr currentHr = HrUtil.getCurrentHr();
        List<Role> roles = currentHr.getRoles();
        List<Menu> menus = new ArrayList<>();
        for (Role role : roles) {
            int rid = role.getId();
            MenuRoleDB menuRoleDB = new MenuRoleDB();
            menuRoleDB.setRid(rid);
            List<Menu> menus1 = menuRoleDBMapper.select(menuRoleDB).stream().map(menuRoleDB1 -> BeanCopyUtil.copy(menuRoleDB1, Menu.class)).collect(Collectors.toList());
            for (Menu menu : menus1) {
                if (!menus.contains(menu)) {
                    menus.add(menu);
                }
            }
        }
        return menus;
    }
}
