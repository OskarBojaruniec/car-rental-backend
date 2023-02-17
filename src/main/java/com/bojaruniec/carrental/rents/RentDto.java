package com.bojaruniec.carrental.rents;

import lombok.*;

import java.sql.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    private long specId;
    private long carId;
    private long userId;
    private Date dateOfRent;
    private Date dateOfReturn;
}
