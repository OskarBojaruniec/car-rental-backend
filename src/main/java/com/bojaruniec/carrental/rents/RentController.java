package com.bojaruniec.carrental.rents;

import com.bojaruniec.carrental.cars.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class RentController {

    private final RentService rentService;


    @GetMapping("/rents")
    public List<Rent> getListOfRents() {
        return rentService.getListOfRents();
    }

    @GetMapping("/rents/cars/{id}")
    public List<Rent> getListOfRentsByCarSpecificationId(@PathVariable("id") long specId) {
        return rentService.getListOfRentsByCarSpecificationId(specId);
    }

    @PostMapping("/rents")
    public Rent addRent(@RequestBody RentDto rentDto) {
        return rentService.addRent(rentDto);
    }

    @PostMapping("/rents/check")
    public Car checkAvailability (@RequestBody RentDto rentDto) {
        return rentService.findAnyAvailableCar(rentDto);
    }

    @DeleteMapping("/rents/{id}")
    public void deleteRent(@PathVariable("id") long id) {
         rentService.delete(id);
    }
}
