package com.user.repository;

import com.user.model.ApplianceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.*;

import java.awt.print.Pageable;

@Repository
public interface ApplianceRepository extends JpaRepository<ApplianceEntity,Long>,JpaSpecificationExecutor<ApplianceEntity>{

//    List<ApplianceEntity> findByBrand(String brand, Pageable pageable);
    
}
