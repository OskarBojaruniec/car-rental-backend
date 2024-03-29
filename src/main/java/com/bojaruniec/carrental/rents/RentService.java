package com.bojaruniec.carrental.rents;

import com.bojaruniec.carrental.cars.Car;
import com.bojaruniec.carrental.cars.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository rentRepository;
    private final CarService carService;

    public Rent addRent(RentDto rentDto) {


        Rent rent = new Rent();
        rent.setCar(carService.getSingleCar(rentDto.getCarId()));
        rent.setUserId(rentDto.getUserId());
        rent.setDateOfRent(rentDto.getDateOfRent());
        rent.setDateOfReturn(rentDto.getDateOfReturn());

        return rentRepository.save(rent);
    }

    public List<Rent> getListOfRents() {
        return rentRepository.findAll();
    }

    public List<Rent> getListOfRentsByCarSpecificationId(long specId) {
        return rentRepository.findAllByCarSpecificationId(specId);
    }

    public List<Rent> getListOfRentsByUserId(long id) {
        return rentRepository.findAllByUserId(id);
    }

    public Car findAnyAvailableCar(RentDto rentDto) { // czas w jakim chcemy wynając , aktualne wynajmy , auta jakie są , znajdź w danym casie auto

        List<Car> carsInRent = getCarsInGivenTime(rentDto);
        List<Car> allCarsWithGivenSpecification = carService.getListOfCarsBySpecification(rentDto.getSpecId());

        Optional<Car> availableCar = allCarsWithGivenSpecification
                .stream()
                .filter(car -> !carsInRent.contains(car))
                .findFirst();

        return availableCar.orElseThrow();
    }

    private List<Car> getCarsInGivenTime(RentDto rentDto) {

        List<LocalDate> datesInRangeOfGivenTime = getAllDatesInRangeOfGivenTime(rentDto);
        List<Rent> rentsInRangeOfGivenTime = getAllRentsMonthBeforeGivenTime(rentDto);
        List<Car> carsInRangeOfGivenTime = new ArrayList<>();

        for (Rent rent : rentsInRangeOfGivenTime) {
            Optional<LocalDate> isDateOccupied = rent.getDateOfRent().toLocalDate()
                    .datesUntil(rent.getDateOfReturn().toLocalDate().plusDays(1))
                    .filter(datesInRangeOfGivenTime::contains)
                    .findFirst();

            if (isDateOccupied.isPresent()) {
                Car car = new Car(rent.getCar().getId(),
                        rent.getCar().getLicensePlate(),
                        rent.getCar().getSpecification());


                carsInRangeOfGivenTime.add(car);
            }
        }
        return carsInRangeOfGivenTime;
    }

    private List<LocalDate> getAllDatesInRangeOfGivenTime(RentDto rentDto) {

        return rentDto.getDateOfRent().toLocalDate()
                .datesUntil(rentDto.getDateOfReturn().toLocalDate().plusDays(1))
                .toList();
    }

    /**
     * @return List of rents month before rent to avoid situation where user want to rent a car which is still in renting;
     * Month because max time of rent is 30 days;
     */
    private List<Rent> getAllRentsMonthBeforeGivenTime(RentDto rentDto) {

        return getListOfRentsByCarSpecificationId(rentDto.getSpecId())
                .stream()
                .filter(rent -> rent.getDateOfRent().toLocalDate().minusMonths(1).isBefore(rentDto.getDateOfRent().toLocalDate()))
                .toList();

    }

    public void delete(long id) {
        rentRepository.delete(rentRepository.findById(id).orElseThrow());
    }
}

