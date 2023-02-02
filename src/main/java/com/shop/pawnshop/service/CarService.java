package com.shop.pawnshop.service;
import com.shop.pawnshop.exception.NotFoundException;
import com.shop.pawnshop.model.Owner;
import com.shop.pawnshop.model.car.Car;
import com.shop.pawnshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car save(Car car) {
        return (Car) carRepository.save(car);
    }

    public Car findById(Long id) {
        return (Car) carRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public List<Car> findAll() {
        return carRepository.findAll().stream().filter(Objects::nonNull).map(c -> (Car) c).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        Car car = findById(id);
        carRepository.delete(car);
    }
}
