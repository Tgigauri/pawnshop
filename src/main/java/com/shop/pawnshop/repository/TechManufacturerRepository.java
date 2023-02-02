package com.shop.pawnshop.repository;


import com.shop.pawnshop.model.technology.TechManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechManufacturerRepository extends JpaRepository<TechManufacturer, Long> {
}

