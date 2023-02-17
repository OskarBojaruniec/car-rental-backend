package com.bojaruniec.carrental.cars;

import com.bojaruniec.carrental.cars.exceptions.CarNotFoundException;
import com.bojaruniec.carrental.cars.specifications.SpecificationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final SpecificationService specificationService;

    // cache
    public Car getSingleCar(long id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    // cache
    public List<Car> getListOfCars() {
        return carRepository.findAll();
    }

    // cache
    public List<Car> getListOfCarsBySpecification(long specId) {
        return carRepository.findAllBySpecificationId(specId);
    }

    public Car addCarWithSpecification(CarDto carDto) {

        Car carToAdd = new Car();
        carToAdd.setLicensePlate(carDto.getLicensePlate());

        if (carDto.getSpecificationId() == 0 && carDto.getSpecification() == null) {
            throw new IllegalArgumentException("Cannot add car by given arguments");
        }

        if (specificationService.getSpecification(carDto.getSpecificationId()).isPresent()) {
            carToAdd.setSpecification(specificationService.getSpecification(carDto.getSpecificationId())
                    .orElseThrow());
        } else {
            carToAdd.setSpecification(specificationService
                    .addSpecification(carDto.getSpecification()));
        }
        return carRepository.save(carToAdd);
    }

    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }


}
