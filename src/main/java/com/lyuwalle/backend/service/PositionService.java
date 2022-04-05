package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.PositionRepo;
import com.lyuwalle.backend.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lyuxiyang
 */
@Service
public class PositionService {

    @Autowired
    private PositionRepo positionRepo;

    public List<Position> getAllPositions() {
        return positionRepo.getAllPositions();
    }

    public int addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionRepo.addPosition(position);
    }

    public int updatePosition(Position position) {
        return positionRepo.updatePosition(position);
    }

    public int deletePositionById(Integer id) {
        return positionRepo.deletePositionById(id);
    }

    public int deletePositionByIds(Integer[] ids) {
        return positionRepo.deletePositionByIds(ids);
    }
}
