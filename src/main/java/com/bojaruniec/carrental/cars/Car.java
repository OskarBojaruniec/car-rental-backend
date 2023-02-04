package com.bojaruniec.carrental.cars;

import com.bojaruniec.carrental.cars.specifications.SpecificationOfCar;


import lombok.*;


import javax.persistence.*;


@Builder
@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    @Column(name = "license_plate")
    private String licensePlate;
    @OneToOne
    @JoinColumn(name = "spec_id")
    private SpecificationOfCar specification;


    public Car(String licensePlate, SpecificationOfCar specification) {
        this.licensePlate = licensePlate;
        this.specification = specification;
    }


}
