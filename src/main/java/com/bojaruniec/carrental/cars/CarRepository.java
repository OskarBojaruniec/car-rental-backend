package com.bojaruniec.carrental.cars;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Override
    @NonNull
    @Query("select distinct c from Car c join fetch c.specification")
    List<Car> findAll();

    List<Car> findAllBySpecificationId(long id);
}
