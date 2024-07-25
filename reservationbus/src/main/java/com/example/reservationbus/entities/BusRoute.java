package com.example.reservationbus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bus_route")
public class BusRoute {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long routeId;
private String cityFrom;
private String cityTo;
private String routeName;
private double distanceInKm;

}
