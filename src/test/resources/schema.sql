CREATE TABLE cars (
    car_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    license_plate VARCHAR(9) NOT NULL,
    date_of_rent timestamp,
    date_of_return timestamp,
    spec_id integer
);


CREATE TABLE specification (
    spec_id  BIGINT AUTO_INCREMENT primary key,
    brand VARCHAR(20) NOT NULL,
    model VARCHAR(30) NOT NULL,
    engine_capacity real NOT NULL,
    horse_power real NOT NULL,
    seats_number integer NOT NULL
);

