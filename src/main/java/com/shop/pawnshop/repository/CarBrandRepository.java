package com.shop.pawnshop.repository;

import com.shop.pawnshop.model.car.Car;
import com.shop.pawnshop.model.car.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
}
