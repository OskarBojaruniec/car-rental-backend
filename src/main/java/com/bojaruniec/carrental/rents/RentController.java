package com.bojaruniec.carrental.rents;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;


    @GetMapping("/rents")
    public List<Rent> getListOfRents() {
        return rentService.getListOfRents();
    }

    @PostMapping("/rents")
    public Rent addRent(@RequestBody RentDto rentDto) {
        return rentService.addRent(rentDto);
    }
}
