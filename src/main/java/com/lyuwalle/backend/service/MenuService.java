package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.MenuRepo;
import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.domain.Menu;
import com.lyuwalle.backend.domain.Role;
import com.lyuwalle.backend.utils.HrUtil;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepo menuRepo;

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

    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        return false;
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
