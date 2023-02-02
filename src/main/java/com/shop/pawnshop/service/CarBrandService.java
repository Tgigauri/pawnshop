package com.shop.pawnshop.service;

import com.shop.pawnshop.exception.NotFoundException;
import com.shop.pawnshop.model.car.Car;
import com.shop.pawnshop.model.car.CarBrand;
import com.shop.pawnshop.repository.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CarBrandService {
    private final CarBrandRepository carBrandRepository;

    public CarBrandService(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }

    public List<CarBrand> getAllCarBrands() {
        return carBrandRepository.findAll().stream().filter(Objects::nonNull).map(c -> (CarBrand) c).collect(Collectors.toList());
    }

    public ResponseEntity<?> createCarBrand(CarBrand carBrand) {
        carBrandRepository.save(carBrand);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public CarBrand getCarBrandbyId(Long carBrandId) {
        return (CarBrand) carBrandRepository.findById(carBrandId).orElseThrow(() -> new NotFoundException(carBrandId));
    }

    public ResponseEntity<?> deleteCarBrand(Long carBrandid) {
        CarBrand carBrand = getCarBrandbyId(carBrandid);
        carBrandRepository.delete(carBrand);
        return ResponseEntity.ok().build();
    }
}
