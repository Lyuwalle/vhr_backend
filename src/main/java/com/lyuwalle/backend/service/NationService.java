package com.lyuwalle.backend.service;

import com.lyuwalle.backend.Repo.NationRepo;
import com.lyuwalle.backend.domain.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyuxiyang
 */
@Service
public class NationService {

    @Autowired
    private NationRepo nationRepo;

    public List<Nation> getAllNations() {
        return nationRepo.getAllNations();
    }
}
