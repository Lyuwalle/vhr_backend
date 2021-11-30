package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Hr;
import com.lyuwalle.backend.domain.Menu;
import com.lyuwalle.backend.domain.Meta;
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

    private static final int startMid = 2;
    private static final int endMid = 6;


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
        //根据所有menuId获取parentId
        List<Integer> parentIdList = menuIdList.stream().map(menuId -> {
            MenuDB menuDB = new MenuDB();
            menuDB.setId(menuId);
            return menuDBMapper.selectOne(menuDB).getParentId();
        }).distinct().collect(Collectors.toList());

        //Todo menuId中的每一个menuId对应的menu的parentId也要包含进来，子菜单有了，父菜单自然也有了
        //Todo 最多只有二级菜单，对一级菜单枚举即可
        //FIXME
        List<Menu> menus = new ArrayList<>();
        for (int mid = startMid; mid <= endMid; mid ++) {
            if (parentIdList.contains(mid)) {
                MenuDB menuDB = new MenuDB();
                menuDB.setId(mid);
                menuDB = menuDBMapper.selectOne(menuDB);
                Menu menu = BeanCopyUtil.copy(menuDB, Menu.class);
                Meta meta = new Meta();
                meta.setRequireAuth(menuDB.getRequireAuth());
                meta.setKeepAlive(menuDB.getKeepAlive());
                menu.setMeta(meta);
                List<Menu> childrenMenu = new ArrayList<>();
                int finalMid = mid;
                menuIdList.forEach(menuId -> {
                    MenuDB menuDB1 = new MenuDB();
                    menuDB1.setId(menuId);
                    menuDB1 = menuDBMapper.selectOne(menuDB1);
                    if (menuDB1.getParentId() == finalMid) {
                        Menu menu1 = BeanCopyUtil.copy(menuDB1, Menu.class);
                        Meta meta1 = new Meta();
                        meta1.setKeepAlive(menuDB1.getKeepAlive());
                        meta1.setRequireAuth(menuDB1.getRequireAuth());
                        menu1.setMeta(meta1);
                        childrenMenu.add(menu1);
                    }
                });
                menu.setChildren(childrenMenu);
                menus.add(menu);
            }
        }
        return menus;
    }
}
