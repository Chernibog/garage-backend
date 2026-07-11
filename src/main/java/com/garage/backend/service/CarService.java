package com.garage.backend.service;

import com.garage.backend.entity.Car;
import com.garage.backend.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Setter
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CarService {


    private final CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Optional<Car> getCarByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }



    @Transactional
    public Car createCar (Car car){

        if (carRepository.existsByLicensePlate(car.getLicensePlate())){
            throw new IllegalArgumentException("Car with license plate" + car.getLicensePlate() + "already exist");
        }
        return carRepository.save(car);

    }

    @Transactional
    public Car updateCar(Long id, Car carDetails){

        Car car = carRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found car with id" +  id));

        car.setBrand(car.getBrand());
        car.setModel(car.getModel());
        car.setYear(car.getYear());
        car.setLicensePlate(car.getLicensePlate());

        return carRepository.save(car);

    }

    @Transactional
    public void deleteCar(Long id){

        if(!carRepository.existsById(id)){

            throw new IllegalArgumentException("Car with id" + id + "not found");

        }

        carRepository.deleteById(id);

    }
}



