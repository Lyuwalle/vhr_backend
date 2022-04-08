package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.DepartmentRepo;
import com.lyuwalle.backend.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lyuxiyang
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> getAllDepartments() {
        Department rootDepartment = new Department();
        rootDepartment.setParentId(-1);
        List<Department> departmentList = departmentRepo.getDepartmentsByParentId(rootDepartment.getParentId());
        for (Department department : departmentList) {
            //一个队列
            LinkedList<Department> departmentLinkedList = new LinkedList<>();
            departmentLinkedList.add(department);
            while (!departmentLinkedList.isEmpty()) {
                if (!departmentLinkedList.peek().getIsParent()) {
                    departmentLinkedList.pop();
                    continue;
                }
                Integer parentId = departmentLinkedList.peek().getId();
                List<Department> childrenDepartmentList = departmentRepo.getDepartmentsByParentId(parentId);
                for (Department department1 : childrenDepartmentList) {
                    departmentLinkedList.add(department1);
                }
                departmentLinkedList.peek().setChildren(childrenDepartmentList);
                departmentLinkedList.pop();
            }
        }
        return departmentList;
    }
}
