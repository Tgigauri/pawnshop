package com.shop.pawnshop.repository;

import com.shop.pawnshop.model.Owner;
import com.shop.pawnshop.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Owner o SET o.balance = coalesce(o.balance, 0) + :value WHERE o.id = :id")
    int addBalance(@Param("id") Long id, @Param("value") Long value);

}
