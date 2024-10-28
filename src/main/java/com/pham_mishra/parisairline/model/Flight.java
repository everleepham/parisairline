package com.pham_mishra.parisairline.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    private String departureCity;
    private String arrivalCity;

    private String departureAirport;
    private LocalDateTime departureDate;

    private String arrivalAirport;
    private LocalDateTime arrivalDate;

    private Double price;

    public void setId(Long id) {
        this.flightId = id;
    }
}
