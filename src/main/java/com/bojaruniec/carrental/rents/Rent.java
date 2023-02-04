package com.bojaruniec.carrental.rents;

import com.bojaruniec.carrental.cars.Car;
import com.bojaruniec.carrental.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rents")
@Getter
@Setter
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private long id;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "date_of_rent")
    private Date dateOfRent;
    @Column(name = "date_of_return")
    private Date dateOfReturn;


}
