package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Menu;
import com.lyuwalle.backend.mapper.MenuDBMapper;
import com.lyuwalle.backend.mapper.MenuRoleDBMapper;
import com.lyuwalle.backend.model.MenuRoleDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
