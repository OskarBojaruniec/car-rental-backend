package com.bojaruniec.carrental.cars.exceptions;

public class SpecificationNotFoundException extends RuntimeException {

    public SpecificationNotFoundException(long id) {
        super(String.format("Specification with id %s not found", id));
    }
}
