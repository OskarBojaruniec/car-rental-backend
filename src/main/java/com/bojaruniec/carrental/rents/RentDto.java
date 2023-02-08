package com.bojaruniec.carrental.rents;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
public class RentDto {

    private long specId;
    private long userId;
    private Date dateOfRent;
    private Date dateOfReturn;
}
