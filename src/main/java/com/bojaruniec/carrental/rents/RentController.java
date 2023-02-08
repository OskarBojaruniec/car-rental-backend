package com.bojaruniec.carrental.rents;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
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
}
