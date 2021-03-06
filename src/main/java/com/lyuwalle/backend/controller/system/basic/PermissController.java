package com.lyuwalle.backend.controller.system.basic;

import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.domain.Menu;
import com.lyuwalle.backend.domain.Role;
import com.lyuwalle.backend.service.MenuService;
import com.lyuwalle.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyuxiyang
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    /**
     * 查询所有菜单：
     * 菜单一共有三级：
     *              所有
     *                  员工资料
     *                      基本资料
     *                      高级资料
     *                  人事管理
     *                      员工资料
     *                      员工奖惩
     *                      。。。
     * @return
     */
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    /**
     * 根据角色id获得菜单mids
     *
     * @param rid
     * @return
     */
    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    /**
     * 更新角色id所对应的菜单mids，mids是这个rid对应的所有的角色，是更新，不是添加
     *
     * @param rid
     * @param mids
     * @return
     */
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新角色成功");
        }
        return RespBean.error("更新角色失败");
    }

    /**
     * 权限组添加角色
     * @param role
     * @return
     */
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加角色成功");
        }
        return RespBean.error("添加角色失败");
    }

    /**
     * 权限组删除角色
     * @param rid
     * @return
     */
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除角色成功");
        }
        return RespBean.error("删除角色失败,该角色下尚有关联的菜单");
    }
}
