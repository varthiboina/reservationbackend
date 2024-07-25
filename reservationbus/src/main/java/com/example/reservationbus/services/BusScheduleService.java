package com.example.reservationbus.services;

import com.example.reservationbus.entities.Bus;
import com.example.reservationbus.entities.BusSchedule;

import java.util.List;

public interface BusScheduleService {

    BusSchedule addSchedule(BusSchedule busSchedule);
    List<BusSchedule> getAllBusSchedule();

    List<BusSchedule> getSchedulesByRoute(String routeName);


}
