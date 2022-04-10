package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Department;
import com.lyuwalle.backend.mapper.DepartmentDBMapper;
import com.lyuwalle.backend.model.DepartmentDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentRepo {

    @Autowired
    private DepartmentDBMapper departmentDBMapper;

    public List<Department> getAllDepartments() {
        List<DepartmentDB> departmentDbList = departmentDBMapper.selectAll();
        return departmentDbList.stream().map(departmentDB -> BeanCopyUtil.copy(departmentDB, Department.class)).collect(Collectors.toList());
    }

    public List<Department> getChildDepartmentsById(Integer id) {
        DepartmentDB departmentDB = new DepartmentDB();
        departmentDB.setParentId(id);
        return departmentDBMapper.select(departmentDB).stream().map(departmentDB1 -> BeanCopyUtil.copy(departmentDB1, Department.class)).collect(Collectors.toList());
    }

    /**
     * 根据parentId查询出所有的部门
     * @param parentId
     * @return
     */
    public List<Department> getDepartmentsByParentId(Integer parentId) {
        DepartmentDB departmentDB = new DepartmentDB();
        departmentDB.setEnabled(true);
        departmentDB.setParentId(parentId);
        return departmentDBMapper.select(departmentDB).stream().map(departmentDB1 ->
                BeanCopyUtil.copy(departmentDB1, Department.class)).collect(Collectors.toList());
    }

    public Integer addDepartment(Integer parentId, String name) {
        DepartmentDB parentDepartment = new DepartmentDB();
        parentDepartment.setId(parentId);
        parentDepartment = departmentDBMapper.selectByPrimaryKey(parentDepartment);

        DepartmentDB departmentDB = new DepartmentDB();
        departmentDB.setParentId(parentId);
        departmentDB.setName(name);
        departmentDB.setEnabled(true);
        departmentDB.setIsParent(false);
        /*department数据库中的DepPath没有被用到，注释掉
        Integer maxId = departmentDBMapper.selectMaxId();
        departmentDB.setDepPath(new StringBuilder(parentDepartment.getDepPath()).
                append(".").append(maxId + 1).toString());*/

        return departmentDBMapper.insert(departmentDB);
    }

    public Integer deleteDepartmentById(Integer id) {
        DepartmentDB departmentDB = new DepartmentDB();
        departmentDB.setId(id);
        //departmentDB.setEnabled(false);
        return departmentDBMapper.deleteByPrimaryKey(departmentDB);
    }

    public Department getDepartmentById(Integer departmentId) {
        DepartmentDB departmentDB = new DepartmentDB();
        departmentDB.setId(departmentId);
        return BeanCopyUtil.copy(departmentDBMapper.selectByPrimaryKey(departmentDB), Department.class);
    }
}
