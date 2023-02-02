package com.shop.pawnshop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "turnover_date")
    protected LocalDate turnoverDate;

    @Column(name = "pawn_branch")
    protected String pawnBranch;

    @Column(name = "money_given")
    protected Long moneyGiven;

    @Column(name = "monthly_payment")
    protected Long monthlyPayment;
}
