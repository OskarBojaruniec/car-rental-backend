package com.bojaruniec.carrental.cars.specifications;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface SpecificationRepository extends JpaRepository<SpecificationOfCar, Long> {


}
