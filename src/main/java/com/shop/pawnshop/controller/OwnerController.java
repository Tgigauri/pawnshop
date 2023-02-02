package com.shop.pawnshop.controller;
import com.shop.pawnshop.model.Owner;
import com.shop.pawnshop.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @PostMapping
    public ResponseEntity<?> createOwner(@Valid @RequestBody Owner owner) {
        return ownerService.createOwner(owner);
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
        return ownerService.deleteOwner(ownerId);
    }


    @PostMapping("/{id}/balance")
    public Owner addBalance(@PathVariable Long id, @RequestParam Long value) {
        return ownerService.addBalance(id, value);
    }
}
