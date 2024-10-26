package com.pham_mishra.parisairline.repository;

import com.pham_mishra.parisairline.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}

