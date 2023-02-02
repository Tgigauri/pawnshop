package com.shop.pawnshop.controller;
import com.shop.pawnshop.model.technology.TechManufacturer;
import com.shop.pawnshop.service.TechManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TechManufacturer> getAllTechManufacturers() {
        return techManufacturerService.getAllTechManufacturers();
    }

    @PostMapping
    public ResponseEntity<?> createTechManufacturer(@Valid @RequestBody TechManufacturer techManufacturer) {
        return techManufacturerService.createTechManufacturer(techManufacturer);
    }

    @GetMapping("/{id}")
    public TechManufacturer getTechManufacturerById(@PathVariable(value = "id") Long technologyId) {
        return techManufacturerService.getTechManufacturerById(technologyId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTechManufacturer(@PathVariable(value = "id") Long technologyId) {
        return techManufacturerService.deleteTechManufacturer(technologyId);
    }
}
