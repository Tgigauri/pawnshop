package com.shop.pawnshop.controller;
import com.shop.pawnshop.model.Owner;
import com.shop.pawnshop.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<?> getAllOwners() {
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.getAllOwners());
    }

    @PostMapping
    public ResponseEntity<?> createOwner(@Valid @RequestBody Owner owner) {
        ownerService.createOwner(owner);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public EntityModel<Owner> getOwnerById(@PathVariable(value = "id") Long ownerId) {
        Owner owner = ownerService.getOwnerById(ownerId);
        EntityModel<Owner> entityModel = EntityModel.of(owner);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllOwners());
        entityModel.add(link.withRel("all-owners"));
        return entityModel;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable(value = "id") Long ownerId) {
        ownerService.deleteOwner(ownerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PostMapping("/{id}/balance")
    public ResponseEntity<?> addBalance(@PathVariable Long id, @RequestParam Long value) {
        ownerService.addBalance(id, value);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
