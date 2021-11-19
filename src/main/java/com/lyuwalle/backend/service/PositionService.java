package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.PositionRepo;
import com.lyuwalle.backend.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
