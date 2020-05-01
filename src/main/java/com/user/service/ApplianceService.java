package com.user.service;

import com.user.model.ApplianceEntity;
import com.user.repository.ApplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplianceService {

    @Autowired
    private ApplianceRepository repository;

    public List<ApplianceEntity> getAllAppliances() {
        return repository.findAll();
    }

    public String h()
    {return "hello";}
}
