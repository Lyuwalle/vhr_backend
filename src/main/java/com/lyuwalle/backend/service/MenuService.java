package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.MenuRepo;
import com.lyuwalle.backend.Repo.MenuRoleRepo;
import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.domain.Menu;
import com.lyuwalle.backend.domain.MenuRole;
import com.lyuwalle.backend.domain.Role;
import com.lyuwalle.backend.utils.HrUtil;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepo menuRepo;
    @Autowired
    private MenuRoleRepo menuRoleRepo;

    public List<Menu> getAllMenus() {
        Menu root = new Menu();
        root.setName("所有");
        root = menuRepo.getRootMenu(root);
        List<Menu> secondClassMenus = menuRepo.getMenusByParentId(root.getId());
        secondClassMenus.forEach(secondClassMenu -> {
            secondClassMenu.setChildren(menuRepo.getMenusByParentId(secondClassMenu.getId()));
        });
        root.setChildren(secondClassMenus);
        List<Menu> allMenus = Lists.newArrayList();
        allMenus.add(root);
        return allMenus;
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuRepo.getMidsByRid(rid);
    }

    /**
     * 这个注解表示添加没有成功，保证删除也不会成功
     * @param rid
     * @param mids
     * @return
     */
    @Transactional(rollbackFor = SQLException.class)
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        //先删除这个rid下面的所有的mid，再添加
        menuRoleRepo.deleteMenuRoleByRid(rid);
        int affectedRows = 0;
        for (Integer mid : mids) {
            MenuRole menuRole = new MenuRole();
            menuRole.setRid(rid);
            menuRole.setMid(mid);
            affectedRows += menuRoleRepo.addMenuRole(menuRole);
        }
        return affectedRows == mids.length;
    }

    /**
     * 根据Hr的id拿到菜单List
     * @return
     */
    public List<Menu> getMenusByHrId() {
        return menuRepo.getMenusByHrId();
    }

    /**
     * @Cacheble 可以加这个注解，但是要配redis
     * @return
     */
    public List<Menu> getAllMenusWithRole() {
        return menuRepo.getAllMenusWithRole();
    }
}
