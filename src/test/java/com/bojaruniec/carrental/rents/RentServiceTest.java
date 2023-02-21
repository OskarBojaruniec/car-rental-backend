package com.bojaruniec.carrental.rents;


import com.bojaruniec.carrental.cars.Car;
import com.bojaruniec.carrental.cars.CarService;

import com.bojaruniec.carrental.cars.specifications.SpecificationOfCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RentServiceTest {


    @Mock
    private CarService carService;

    @Mock
    private RentRepository rentRepository;

    @InjectMocks
    private RentService rentService;

    @Test
    void shouldFindCarWithGivenDate() {
        SpecificationOfCar specification = SpecificationOfCar.builder()
                .id(3)
                .build();
        RentDto rentDto = RentDto.builder()
                .dateOfRent(new Date(1645398000000L))
                .dateOfReturn(new Date(1645916400000L))
                .carId(1)
                .build();  // YYYY-MM-DD 2022-02-21 , 2022-02-27
        Car car = Car.builder()
                .id(1)
                .licensePlate(" ")
                .specification(specification)
                .build();
        Car car2 = Car.builder()
                .id(2)
                .licensePlate(" ")
                .specification(specification)
                .build();
        List<Car> listOfCars = new ArrayList<>();
        listOfCars.add(car);
        listOfCars.add(car2);
        Rent rent = Rent.builder()
                .dateOfRent(new Date(1644706800000L))
                .dateOfReturn(new Date(1645052400000L))
                .car(car)
                .build(); // 2022-02-13, 2022-02-17
        Rent rent2 = Rent.builder()
                .dateOfRent(new Date(1645398000000L))
                .dateOfReturn(new Date(1645916400000L))
                .car(car2)
                .build(); // 2022-02-21 , 2022-02-27
        List<Rent> listOfRents = new ArrayList<>();
        listOfRents.add(rent);
        listOfRents.add(rent2);
        //when
        when(carService.getListOfCarsBySpecification(0)).thenReturn(listOfCars);
        when(rentService.getListOfRentsByCarSpecificationId(0)).thenReturn(listOfRents);
        //then
        Assertions.assertSame(rentService.findAnyAvailableCar(rentDto).getId(), rentDto.getCarId());

    }

    @Test
    void shouldThrowWhenNoneIsAvailable() {
        SpecificationOfCar specification = SpecificationOfCar.builder()
                .id(3)
                .build();
        RentDto rentDto = RentDto.builder()
                .dateOfRent(new Date(1645398000000L))
                .dateOfReturn(new Date(1645916400000L))
                .carId(1)
                .build();  // YYYY-MM-DD 2022-02-21 , 2022-02-27
        Car car = Car.builder()
                .id(1)
                .licensePlate(" ")
                .specification(specification)
                .build();
        Car car2 = Car.builder()
                .id(2)
                .licensePlate(" ")
                .specification(specification)
                .build();
        List<Car> listOfCars = new ArrayList<>();
        listOfCars.add(car);
        listOfCars.add(car2);
        Rent rent = Rent.builder()
                .dateOfRent(new Date(1644706800000L))
                .dateOfReturn(new Date(1645570800000L))
                .car(car)
                .build(); // 2022-02-13, 2022-02-24
        Rent rent2 = Rent.builder()
                .dateOfRent(new Date(1645398000000L))
                .dateOfReturn(new Date(1645916400000L))
                .car(car2)
                .build(); // 2022-02-21 , 2022-02-27
        List<Rent> listOfRents = new ArrayList<>();
        listOfRents.add(rent);
        listOfRents.add(rent2);
        //when
        when(carService.getListOfCarsBySpecification(0)).thenReturn(listOfCars);
        when(rentService.getListOfRentsByCarSpecificationId(0)).thenReturn(listOfRents);
        //then
        Assertions.assertThrows(NoSuchElementException.class, () -> rentService.findAnyAvailableCar(rentDto));

    }


}