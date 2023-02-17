package com.bojaruniec.carrental.rents;


import com.bojaruniec.carrental.cars.CarService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RentServiceTest {



    @Mock
    private CarService carService;

    @Mock
    private RentRepository rentRepository;

    @InjectMocks
    private RentService rentService;




}