package com.garage.backend.repository;

import com.garage.backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
/* Наследуем JpaRepository
    Car - entity
    Long - айди
 */
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByLicensePlate(String licensePlate);
    boolean existsByLicensePlate(String licensePlate);

}
