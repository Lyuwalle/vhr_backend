package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Position;
import com.lyuwalle.backend.mapper.EmployeeDBMapper;
import com.lyuwalle.backend.mapper.PositionDBMapper;
import com.lyuwalle.backend.model.EmployeeDB;
import com.lyuwalle.backend.model.PositionDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionRepo {

    @Autowired
    private PositionDBMapper positionDBMapper;
    @Autowired
    private EmployeeDBMapper employeeDBMapper;


    public List<Position> getAllPositions() {
        return positionDBMapper.selectAll().stream().map(positionDB -> {
            Position position = BeanCopyUtil.copy(positionDB, Position.class);
            return position;
        }).collect(Collectors.toList());
    }

    public int addPosition(Position position) {
        return positionDBMapper.insert(BeanCopyUtil.copy(position, PositionDB.class));
    }

    public int updatePosition(Position position) {
        return positionDBMapper.updateByPrimaryKeySelective(BeanCopyUtil.copy(position, PositionDB.class));
    }

    public int deletePositionById(Integer id) {
        EmployeeDB employeeDB = new EmployeeDB();
        employeeDB.setPosId(id);
        List<EmployeeDB> employeeDBS = employeeDBMapper.select(employeeDB);
        if (employeeDBS.size() > 0) {
            return -1;
        }
        PositionDB positionDB = new PositionDB();
        positionDB.setId(id);
        return positionDBMapper.delete(positionDB);
    }

    public int deletePositionByIds(Integer[] ids) {
        for(Integer id : ids) {
            EmployeeDB employeeDB = new EmployeeDB();
            employeeDB.setPosId(id);
            List<EmployeeDB> employeeDBS = employeeDBMapper.select(employeeDB);
            if (employeeDBS.size() > 0) {
                return -1;
            }
        }
        int result = 0;
        for (Integer id : ids) {
            PositionDB positionDB = new PositionDB();
            positionDB.setId(id);
            result += positionDBMapper.delete(positionDB);
        }
        return result;
    }
}
