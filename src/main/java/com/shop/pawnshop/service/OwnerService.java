package com.shop.pawnshop.service;

import com.shop.pawnshop.exception.NotFoundException;
import com.shop.pawnshop.model.Owner;
import com.shop.pawnshop.model.car.Car;
import com.shop.pawnshop.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll().stream().filter(Objects::nonNull).map(c -> (Owner) c).collect(Collectors.toList());
    }

    public ResponseEntity<?> createOwner(Owner owner) {
         ownerRepository.save(owner);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public Owner getOwnerById(Long ownerId) {
        return (Owner) ownerRepository.findById(ownerId).orElseThrow(() -> new NotFoundException(ownerId));
    }

    public ResponseEntity<?> deleteOwner(Long ownerId) {
        Owner owner = getOwnerById(ownerId);
        ownerRepository.delete(owner);
        return ResponseEntity.ok().build();
    }

    public Owner addBalance(Long id, Long value) {
        ownerRepository.addBalance(id, value);
        return ownerRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}
