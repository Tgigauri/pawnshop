package com.shop.pawnshop.controller;


import com.shop.pawnshop.model.technology.Technology;

import com.shop.pawnshop.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Technology> getAllTechnology() {
        return technologyService.getAllTechnology();
    }

    @PostMapping
    public ResponseEntity<?> createTechnology(@Valid @RequestBody Technology technology) {
        return technologyService.createTechnology(technology);
    }

    @GetMapping("/{id}")
    public Technology getTechnologyById(@PathVariable(value = "id") Long technologyId) {
        return technologyService.getTechnologyById(technologyId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTechnology(@PathVariable(value = "id") Long technologyId) {
        return technologyService.deleteTechnology(technologyId);
    }
}
