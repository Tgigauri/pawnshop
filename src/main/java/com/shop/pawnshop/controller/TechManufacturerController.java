package com.shop.pawnshop.controller;
import com.shop.pawnshop.model.technology.TechManufacturer;
import com.shop.pawnshop.service.TechManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/techManufacturer")
public class TechManufacturerController {
    private final TechManufacturerService techManufacturerService;

    public TechManufacturerController(TechManufacturerService techManufacturerService) {
        this.techManufacturerService = techManufacturerService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTechManufacturers() {
        return ResponseEntity.status(HttpStatus.OK).body(techManufacturerService.getAllTechManufacturers());
    }

    @PostMapping
    public ResponseEntity<?> createTechManufacturer(@Valid @RequestBody TechManufacturer techManufacturer) {
        techManufacturerService.createTechManufacturer(techManufacturer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getTechManufacturerById(@PathVariable(value = "id") Long technologyId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(techManufacturerService.getTechManufacturerById(technologyId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTechManufacturer(@PathVariable(value = "id") Long technologyId) {
        techManufacturerService.deleteTechManufacturer(technologyId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
