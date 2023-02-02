package com.shop.pawnshop.scheduler;


import com.shop.pawnshop.model.Owner;
import com.shop.pawnshop.model.car.Car;
import com.shop.pawnshop.repository.CarRepository;
import com.shop.pawnshop.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Component
public class PaymentDeduction {

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public PaymentDeduction(CarRepository carRepository,OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void extractMonthlyPayments() {
        Map<Long, Long> ownerPayments = new HashMap<>();
        List<Car> cars = carRepository.findAll();
        for (Car car : cars) {
            Long ownerId = car.getOwner().getId();
            long monthlyPayment = car.getMonthlyPayment();
            ownerPayments.put(ownerId, ownerPayments.getOrDefault(ownerId, 0l) + monthlyPayment);
        }

        for (Map.Entry<Long, Long> entry : ownerPayments.entrySet()) {
            Long ownerId = entry.getKey();
            long totalMonthlyPayment = entry.getValue();
            Owner owner = ownerRepository.findById(ownerId).orElse(null);
            if (owner == null) {
                continue;
            }
            long balance = owner.getBalance();
            if (totalMonthlyPayment > balance) {
                log.info("Owner ID: " + ownerId + " Not Enough Money. Total Monthly Payment: " + totalMonthlyPayment + " Balance: " + balance);
            } else {
                log.info("Owner ID: " + ownerId + " Total Monthly Payment: " + totalMonthlyPayment + " Balance: " + balance);
            }
        }
    }
}
