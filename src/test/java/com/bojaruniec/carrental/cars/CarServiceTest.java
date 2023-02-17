package com.bojaruniec.carrental.cars;

import com.bojaruniec.carrental.cars.exceptions.CarNotFoundException;

import com.bojaruniec.carrental.cars.specifications.SpecificationOfCar;
import com.bojaruniec.carrental.cars.specifications.SpecificationService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    @Mock
    private SpecificationService specificationService;

    @InjectMocks
    private CarService carService;


    @Test
    void canGetSingleCar() {
        // given
        long id = anyLong();
        SpecificationOfCar specification = new SpecificationOfCar("",
                "",
                0.0,
                0.0,
                0,
                null);

        Car car = new Car("", specification);
        when(carRepository.findById(id)).thenReturn(Optional.of(car));
        // when
        carService.getSingleCar(id);
        // then
        verify(carRepository, times(1)).findById(id);
        verifyNoMoreInteractions(carRepository);
    }

    @Test
    void shouldThrowWhenSingleCarNotExist() {
        // given
        long id = anyLong();
        // then
        assertThatThrownBy(() -> carService.getSingleCar(id))
                .isInstanceOf(CarNotFoundException.class)
                .hasMessageContaining("Car with id %s not found", id);
    }

    @Test
    void canGetListOfCars() {
        // when
        carService.getListOfCars();
        // then
        verify(carRepository).findAll();
    }

    @Test
    void shouldAddCarWhenOnlySpecificationIdIsGiven() {
        // given
        long id = 1;
        CarDto carWithSpecificationId =
                new CarDto("", id);
        SpecificationOfCar specification = new SpecificationOfCar("",
                "",
                0.0,
                0.0,
                0,
                null);

        when(specificationService.getSpecification(id)).thenReturn(Optional.of(specification));
        // when
        carService.addCarWithSpecification(carWithSpecificationId);
        // then
        verify(specificationService, times(2)).getSpecification(id);
        verify(carRepository, times(1)).save(Mockito.any(Car.class));
        verify(specificationService, times(0))
                .addSpecification(Mockito.any(SpecificationOfCar.class));
    }

    @Test
    void shouldAddNewCarWhenOnlySpecificationIsGiven() {
        // given
        long id = anyLong();
        SpecificationOfCar specification = new SpecificationOfCar("",
                "",
                0.0,
                0.0,
                0,
                null);
        CarDto carWithSpecification =
                new CarDto("", specification);
        // when
        carService.addCarWithSpecification(carWithSpecification);
        // then
        verify(specificationService, times(1)).getSpecification(id);
        verify(specificationService, times(1)).addSpecification(specification);
        verify(carRepository, times(1)).save(Mockito.any(Car.class));
    }

    @Test
    void shouldThrowWhenSpecificationIdAndSpecificationIsNotGiven() {
        //given
        CarDto carToAdd = new CarDto();
        //then
        assertThatThrownBy(() -> carService.addCarWithSpecification(carToAdd))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cannot add car by given arguments");

    }
}