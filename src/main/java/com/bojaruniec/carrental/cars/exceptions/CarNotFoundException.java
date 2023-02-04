package com.bojaruniec.carrental.cars.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class CarNotFoundException extends RuntimeException {


    public CarNotFoundException (long id) {
        super(String.format("Car with id %s not found", id));
    }
}
