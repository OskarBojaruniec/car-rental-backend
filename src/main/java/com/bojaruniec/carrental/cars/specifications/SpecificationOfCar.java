package com.bojaruniec.carrental.cars.specifications;

import com.bojaruniec.carrental.images.Image;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "specifications")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SpecificationOfCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spec_id")
    private long id;
    private String brand;
    private String model;
    @Column(name = "engine_capacity")
    private double engineCapacity;
    @Column(name = "horse_power")
    private double horsePower;
    @Column(name = "seats_number")
    private int seatsNumber;
    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public SpecificationOfCar(String brand, String model, double engineCapacity, double horsePower, int seatsNumber, Image image) {
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.horsePower = horsePower;
        this.seatsNumber = seatsNumber;
        this.image = image;
    }
}