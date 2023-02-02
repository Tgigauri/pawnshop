package com.shop.pawnshop.service;
import com.shop.pawnshop.exception.NotFoundException;
import com.shop.pawnshop.model.technology.TechManufacturer;
import com.shop.pawnshop.repository.TechManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TechManufacturerService {

    private final TechManufacturerRepository techManufacturerRepository;

    public TechManufacturerService(TechManufacturerRepository techManufacturerRepository) {
        this.techManufacturerRepository = techManufacturerRepository;
    }

    public List<TechManufacturer> getAllTechManufacturers() {
        return techManufacturerRepository.findAll().stream().filter(Objects::nonNull).map(c -> (TechManufacturer) c).collect(Collectors.toList());

    }

    public ResponseEntity<?> createTechManufacturer(TechManufacturer techManufacturer) {
        techManufacturerRepository.save(techManufacturer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public TechManufacturer getTechManufacturerById(Long techManufacturerId) {
        return (TechManufacturer) techManufacturerRepository.findById(techManufacturerId).orElseThrow(() -> new NotFoundException(techManufacturerId));
    }

    public ResponseEntity<?> deleteTechManufacturer(Long techManufacturerId) {
        TechManufacturer techManufacturer = getTechManufacturerById(techManufacturerId);
        techManufacturerRepository.delete(techManufacturer);
        return ResponseEntity.ok().build();
    }
}
