package com.user.web;

import com.sipios.springsearch.anotation.SearchSpec;
import com.user.exception.RecordNotFoundException;
import com.user.model.ApplianceEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.user.repository.ApplianceRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/appliances")
public class ApplianceController {


    @Autowired
    private ApplianceRepository repository;

    /**Get the entire list of appliances**/

    @GetMapping("/")
    public List<ApplianceEntity> getAllAppliances(){
        return repository.findAll();
    }

    /**Create a new appliance**/

    @PostMapping("/")
    public ApplianceEntity createAppliance(@Valid @RequestBody ApplianceEntity appliance) {
        return repository.save(appliance);
    }

    /**Get the appliance by Serial Number**/

    @GetMapping("/{id}")
    public ResponseEntity < ApplianceEntity > getApplianceById(@PathVariable(value = "id") Long serialNo)
            throws RecordNotFoundException {
        ApplianceEntity appliance = repository.findById(serialNo)
                .orElseThrow(() -> new RecordNotFoundException("Appliance not found for this id :: " + serialNo));
        return ResponseEntity.ok().body(appliance);
    }


    /*** Search the appliance by brand/Model/status ***/

    @GetMapping("/search")
    public ResponseEntity<List<ApplianceEntity>> searchForAppliances(@SearchSpec Specification<ApplianceEntity> specs) {

            return new ResponseEntity<>(repository.findAll(Specification.where(specs)), HttpStatus.OK);

    }

    /*** Update the appliance by brand,Model,status ***/

    @PutMapping("/update/{id}")
    public ResponseEntity < ApplianceEntity > updateAppliances(@PathVariable(value = "id") Long serialNo,
                                                      @Valid @RequestBody ApplianceEntity applianceDetails) throws RecordNotFoundException {

        ApplianceEntity applianceEntity = repository.findById(serialNo)
                .orElseThrow(() -> new RecordNotFoundException("Appliance not found for this id :: " + serialNo));

        applianceEntity.setBrand(applianceDetails.getBrand());
        applianceEntity.setModel(applianceDetails.getModel());
        applianceEntity.setStatus(applianceDetails.getStatus());
        applianceEntity.setDate(new java.util.Date());
        final ApplianceEntity updatedAppliance = repository.save(applianceEntity);
        return ResponseEntity.ok(updatedAppliance);
    }

    /*** Delete appliance by Serial no ***/

    @DeleteMapping("/delete/{id}")
    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long serialNo)
            throws ResourceNotFoundException {
        ApplianceEntity employee = repository.findById(serialNo)
                .orElseThrow(() -> new ResourceNotFoundException("Appliance not found for this id :: " + serialNo));

        repository.delete(employee);
        Map< String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
