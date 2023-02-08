package com.bojaruniec.carrental;

import com.bojaruniec.carrental.cars.Car;
import com.bojaruniec.carrental.rents.Rent;
import com.bojaruniec.carrental.rents.RentDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Date;

@SpringBootApplication
@ComponentScan
public class CarRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
    }

}
