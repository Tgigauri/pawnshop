package com.shop.pawnshop.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.pawnshop.model.car.Car;
import com.shop.pawnshop.model.technology.Technology;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Car> cars;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Technology> technologies;

    @Column(name = "balance")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long balance;

}
