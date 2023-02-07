package com.shop.pawnshop.controller;


import com.shop.pawnshop.model.technology.Technology;

import com.shop.pawnshop.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/technology")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTechnology() {
        return ResponseEntity.status(HttpStatus.OK).body(technologyService.getAllTechnology());
    }

    @PostMapping
    public ResponseEntity<?> createTechnology(@Valid @RequestBody Technology technology) {
        technologyService.createTechnology(technology);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTechnologyById(@PathVariable(value = "id") Long technologyId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(technologyService.getTechnologyById(technologyId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTechnology(@PathVariable(value = "id") Long technologyId) {
        technologyService.deleteTechnology(technologyId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
