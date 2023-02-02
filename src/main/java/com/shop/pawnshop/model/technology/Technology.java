package com.shop.pawnshop.model.technology;
import com.shop.pawnshop.model.Item;
import com.shop.pawnshop.model.Owner;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Technology")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Technology extends Item {
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "technology_type")
    @NotNull
    private TechnologyType technologyType;

    @JoinColumn(name = "manufacturer")
    @NotNull
    private String manufacturer;

    @Column(name = "damage")
    @NotNull
    private boolean isDamaged;

    @Column(name = "damage_description")
    private String damageDescription;

}
