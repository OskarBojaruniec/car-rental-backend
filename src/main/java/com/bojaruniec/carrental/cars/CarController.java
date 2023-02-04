package com.bojaruniec.carrental.cars;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {

    private final CarService carService;

    @GetMapping("/cars/{id}")
    public Car getSingleCar(@PathVariable("id") long id) {
        return carService.getSingleCar(id);
    }

    @GetMapping("/cars")
    public List<Car> getListOfCars(HttpServletResponse response) {
        return carService.getListOfCars();
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody CarDto carDto) {
        return carService.addCarWithSpecification(carDto);
    }


    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable long id) {
        carService.deleteCar(id);
    }


}
