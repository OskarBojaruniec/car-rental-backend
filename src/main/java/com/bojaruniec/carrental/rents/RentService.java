package com.bojaruniec.carrental.rents;

import com.bojaruniec.carrental.cars.CarService;
import com.bojaruniec.carrental.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository rentRepository;
    private final UserService userService;
    private final CarService carService;

    public Rent addRent(RentDto rentDto) {

        Rent rent = new Rent();
        rent.setCar(carService.getSingleCar(rentDto.getCarId()));
        rent.setUser(userService.getSingleUser(rentDto.getUserId()));
        rent.setDateOfRent(rentDto.getDateOfRent());
        rent.setDateOfReturn(rentDto.getDateOfReturn());

        return rentRepository.save(rent);
    }

    public List<Rent> getListOfRents() {
        return rentRepository.findAll();
    }
}
