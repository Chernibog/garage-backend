package com.garage.backend.controller;

import com.garage.backend.entity.Car;
import com.garage.backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {


    private final CarService carService;


    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){

        return ResponseEntity.ok(carService.getAllCars());

    }


    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){

        return carService.getCarById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());


    }


    @GetMapping("/plate/{licensePlate}")
    public ResponseEntity<Car> getCarByLicensePlate(@PathVariable String licensePlate) {
        return carService.getCarByLicensePlate(licensePlate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        Car updatedCar = carService.updateCar(id, carDetails);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

}



