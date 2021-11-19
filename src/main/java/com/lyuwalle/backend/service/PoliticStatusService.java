package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.PoliticsStatusRepo;
import com.lyuwalle.backend.domain.PoliticsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyuxiyang
 */
@Service
public class PoliticStatusService {

    @Autowired
    private PoliticsStatusRepo politicsStatusRepo;

    public List<PoliticsStatus> getAllPoliticStatuses() {
        return politicsStatusRepo.getAllPoliticStatuses();
    }
}
