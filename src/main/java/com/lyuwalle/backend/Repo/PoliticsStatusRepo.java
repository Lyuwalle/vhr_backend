package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.PoliticsStatus;
import com.lyuwalle.backend.mapper.PoliticsStatusDBMapper;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoliticsStatusRepo {

    @Autowired
    private PoliticsStatusDBMapper politicsStatusDBMapper;

    public List<PoliticsStatus> getAllPoliticStatuses() {
        return politicsStatusDBMapper.selectAll().stream().map(politicsStatusDB ->
                BeanCopyUtil.copy(politicsStatusDB, PoliticsStatus.class)).collect(Collectors.toList());
    }
}