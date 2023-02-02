package com.shop.pawnshop.service;
import com.shop.pawnshop.exception.NotFoundException;
import com.shop.pawnshop.model.technology.TechManufacturer;
import com.shop.pawnshop.model.technology.Technology;
import com.shop.pawnshop.model.technology.TechnologyType;
import com.shop.pawnshop.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TechnologyService {
    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public List<Technology> getAllTechnology() {
        return technologyRepository.findAll().stream().filter(Objects::nonNull).map(c -> (Technology) c).collect(Collectors.toList());

    }

    public ResponseEntity<?> createTechnology(Technology technology) {
        technologyRepository.save(technology);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public Technology getTechnologyById(Long technologyId) {
        return (Technology) technologyRepository.findById(technologyId).orElseThrow(() -> new NotFoundException(technologyId));
    }

    public ResponseEntity<?> deleteTechnology(Long technologyId) {
        Technology technology = getTechnologyById(technologyId);
        technologyRepository.delete(technology);
        return ResponseEntity.ok().build();
    }
}
