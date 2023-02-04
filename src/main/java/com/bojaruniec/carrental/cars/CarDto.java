package com.bojaruniec.carrental.cars;

import com.bojaruniec.carrental.cars.specifications.SpecificationOfCar;
import lombok.*;
import org.springframework.lang.Nullable;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private String licensePlate;
    private long specificationId;

    @Nullable
    private SpecificationOfCar specification;


    public CarDto(String licensePlate, long specificationId) {
        this.licensePlate = licensePlate;
        this.specificationId = specificationId;
    }

    public CarDto(String licensePlate, @Nullable SpecificationOfCar specification) {
        this.licensePlate = licensePlate;
        this.specification = specification;
    }

}