package com.shop.pawnshop.controller;
import com.shop.pawnshop.model.car.CarBrand;
import com.shop.pawnshop.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/carBrands")
public class CarBrandController {

    private final CarBrandService carBrandService;

    public CarBrandController(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCarBrands() {
        return ResponseEntity.status(HttpStatus.OK).body(carBrandService.getAllCarBrands());
    }

    @PostMapping
    public ResponseEntity<?> createCarBrand(@Valid @RequestBody CarBrand carBrand) {
         carBrandService.createCarBrand(carBrand);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarBrandById(@PathVariable(value = "id") Long carBrandId) {
        return ResponseEntity.status(HttpStatus.OK).body(carBrandService.getCarBrandbyId(carBrandId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarBrand(@PathVariable(value = "id") Long carBrandId) {
        carBrandService.deleteCarBrand(carBrandId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}