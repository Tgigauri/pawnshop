package com.shop.pawnshop.model.car;

import com.shop.pawnshop.model.Item;
import com.shop.pawnshop.model.Owner;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "Car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Car extends Item {

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private CarBrand carBrand;


    @Column(name = "model")
    @NotNull
    private String model;


    @Column(name = "release_date")
    @NotNull
    @Past
    private LocalDate releaseDate;
}
