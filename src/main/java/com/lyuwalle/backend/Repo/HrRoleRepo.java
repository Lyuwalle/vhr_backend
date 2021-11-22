package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.common.BaseException;
import com.lyuwalle.backend.mapper.HrRoleDBMapper;
import com.lyuwalle.backend.model.HrRoleDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrRoleRepo {

    @Autowired
    private HrRoleDBMapper hrRoleDBMapper;

    /**
     * 在hr_role表中更新hr的角色rid
     *
     * @param hrid
     * @param rids
     * @return
     */
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        //1. 先删除hrid下面的所有角色
        HrRoleDB hrRoleDB = new HrRoleDB();
        hrRoleDB.setHrid(hrid);
        try {
            hrRoleDBMapper.delete(hrRoleDB);
        } catch (Exception e) {
            BaseException.cast("删除失败" + e.getMessage());
        }
        //2. 给hrid添加rids角色
        hrRoleDB.setHrid(hrid);
        for (Integer rid : rids) {
            hrRoleDB.setRid(rid);
            try {
                hrRoleDBMapper.insert(hrRoleDB);
            } catch (Exception e) {
                BaseException.cast("插入失败" + e.getMessage());
            }
        }
        return true;
    }
}
