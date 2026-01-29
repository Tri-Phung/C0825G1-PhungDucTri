package com.codegym.phone_management.controller;

import com.codegym.phone_management.entity.Smartphone;
import com.codegym.phone_management.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/smartphones")
public class SmartphoneController {
    @Autowired
    private IService smartphoneService;
    @PostMapping
    public ResponseEntity<?> createSmartphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }


}
