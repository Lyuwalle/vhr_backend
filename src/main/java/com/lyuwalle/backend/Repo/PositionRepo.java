package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Position;
import com.lyuwalle.backend.mapper.PositionDBMapper;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionRepo {

    @Autowired
    private PositionDBMapper positionDBMapper;


    public List<Position> getAllPositions() {
        return positionDBMapper.selectAll().stream().map(positionDB ->
                BeanCopyUtil.copy(positionDB, Position.class)).collect(Collectors.toList());
    }
}
