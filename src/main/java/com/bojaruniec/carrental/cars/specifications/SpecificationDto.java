package com.bojaruniec.carrental.cars.specifications;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Null;


@Data
@Getter
@Setter
@RequiredArgsConstructor
public class SpecificationDto {

    @Nullable
    private SpecificationOfCar specification;
    private long specificationId;
    private long imageId;

}
