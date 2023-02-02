package com.shop.pawnshop.controller;
import com.shop.pawnshop.model.car.CarBrand;
import com.shop.pawnshop.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CarBrand> getAllCarBrands() {
        return carBrandService.getAllCarBrands();
    }

    @PostMapping
    public ResponseEntity<?> createCarBrand(@Valid @RequestBody CarBrand carBrand) {
        return carBrandService.createCarBrand(carBrand);
    }

    @GetMapping("/{id}")
    public CarBrand getCarBrandById(@PathVariable(value = "id") Long carBrandId) {
        return carBrandService.getCarBrandbyId(carBrandId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarBrand(@PathVariable(value = "id") Long carBrandId) {
        return carBrandService.deleteCarBrand(carBrandId);
    }
}