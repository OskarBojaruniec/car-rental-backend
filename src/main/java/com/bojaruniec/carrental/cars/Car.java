package com.bojaruniec.carrental.cars;

import com.bojaruniec.carrental.cars.specifications.SpecificationOfCar;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;


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
    private long id;
    @Column(name = "license_plate")
    private String licensePlate;
    @OneToOne
    @JoinColumn(name = "spec_id")
    private SpecificationOfCar specification;


    public Car(String licensePlate, SpecificationOfCar specification) {
        this.licensePlate = licensePlate;
        this.specification = specification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;

        return getId() == car.getId() && getLicensePlate().equals(car.getLicensePlate()) && getSpecification().equals(car.getSpecification());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLicensePlate(), getSpecification());
    }
}
