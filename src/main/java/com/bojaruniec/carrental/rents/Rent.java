package com.bojaruniec.carrental.rents;

import com.bojaruniec.carrental.cars.Car;
import com.bojaruniec.carrental.users.User;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Builder
@Entity
@Table(name = "rents")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private long id;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @JoinColumn(name = "user_id")
    private long userId;
    @Column(name = "date_of_rent")
    private Date dateOfRent;
    @Column(name = "date_of_return")
    private Date dateOfReturn;


}
