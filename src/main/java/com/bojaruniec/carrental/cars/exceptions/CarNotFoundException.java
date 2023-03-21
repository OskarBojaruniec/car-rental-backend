package com.bojaruniec.carrental.cars.exceptions;

public class CarNotFoundException extends RuntimeException {


    public CarNotFoundException(long id) {
        super(String.format("Car with id %s not found", id));
    }
}
