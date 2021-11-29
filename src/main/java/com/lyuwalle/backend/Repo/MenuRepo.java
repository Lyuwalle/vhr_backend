package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.domain.Menu;
import com.lyuwalle.backend.domain.Meta;
import com.lyuwalle.backend.domain.Role;
import com.lyuwalle.backend.mapper.HrRoleDBMapper;
import com.lyuwalle.backend.mapper.MenuDBMapper;
import com.lyuwalle.backend.mapper.MenuRoleDBMapper;
import com.lyuwalle.backend.model.HrRoleDB;
import com.lyuwalle.backend.model.MenuDB;
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
    @Autowired
    private HrRoleDBMapper hrRoleDBMapper;


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
        Integer hrId = currentHr.getId();
        HrRoleDB hrRoleDB = new HrRoleDB();
        hrRoleDB.setHrid(hrId);
        List<HrRoleDB> hrRoleDBS = hrRoleDBMapper.select(hrRoleDB);
        //获取这个hrId对应的rid列表
        List<Integer> ridList = hrRoleDBS.stream().map(HrRoleDB::getRid).distinct().collect(Collectors.toList());
        //再根据menu_role获取menu列表
        List<Integer> menuIdList = new ArrayList<>();
        ridList.forEach(rid -> {
            MenuRoleDB menuRoleDB = new MenuRoleDB();
            menuRoleDB.setRid(rid);
            List<MenuRoleDB> menuRoleDBS = menuRoleDBMapper.select(menuRoleDB);
            menuRoleDBS.forEach(menuRoleDB1 -> {
                Integer mid = menuRoleDB1.getMid();
                if (!menuIdList.contains(mid)) {
                    menuIdList.add(mid);
                }
            });
        });

        //@Todo menuId中的每一个menuId对应的menu的parentId也要包含进来，子菜单有了，父菜单自然也有了
        List<MenuDB> menuDBList = new ArrayList<>();
        menuIdList.forEach(mid -> {
            MenuDB menuDB = new MenuDB();
            menuDB.setId(mid);
            MenuDB menuDB1 = menuDBMapper.selectOne(menuDB);
            menuDBList.add(menuDB1);
        });

        return menuDBList.stream().map(menuDB -> {
            Menu menu = BeanCopyUtil.copy(menuDB, Menu.class);
            Meta meta = new Meta();
            meta.setKeepAlive(menuDB.getKeepAlive());
            meta.setRequireAuth(menuDB.getRequireAuth());
            menu.setMeta(meta);
            Integer mid = menuDB.getId();
            MenuDB menuDB1 = new MenuDB();
            menuDB1.setParentId(mid);
            List<MenuDB> childrenMenuDB = menuDBMapper.select(menuDB1);
            List<Menu> children = childrenMenuDB.stream().map(child -> {
                Menu menu1 = BeanCopyUtil.copy(child, Menu.class);
                Meta meta1 = new Meta();
                meta1.setKeepAlive(child.getKeepAlive());
                meta1.setRequireAuth(child.getRequireAuth());
                menu1.setMeta(meta1);
                return menu1;
            }).collect(Collectors.toList());

            menu.setChildren(children);
            return menu;
        }).collect(Collectors.toList());
    }
}
