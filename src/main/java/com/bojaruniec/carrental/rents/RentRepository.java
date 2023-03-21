package com.bojaruniec.carrental.rents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findAllByCarSpecificationId(long carSpecId);

    List<Rent> findAllByUserId(long id);
}
