package com.example.reservationbus.services.impl;

import com.example.reservationbus.entities.BusRoute;
import com.example.reservationbus.entities.BusSchedule;
import com.example.reservationbus.models.ReservationApiException;
import com.example.reservationbus.repos.BusRouteRepository;
import com.example.reservationbus.repos.BusScheduleRepository;
import com.example.reservationbus.services.BusScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {


    private BusRouteRepository busRouteRepository;
    private BusScheduleRepository busScheduleRepository;

    @Override
    public BusSchedule addSchedule(BusSchedule busSchedule) {
        final boolean exists = busScheduleRepository.existsByBusAndBusRouteAndDepartureTime(busSchedule.getBus(),busSchedule.getBusRoute(),busSchedule.getDepartureTime());
        if(exists)
        {
            throw new ReservationApiException(HttpStatus.CONFLICT, "Duplicate request");
        }
        else {
            return busScheduleRepository.save(busSchedule);
        }

    }

    @Override
    public List<BusSchedule> getAllBusSchedule() {
        return busScheduleRepository.findAll();
    }

    @Override
    public List<BusSchedule> getSchedulesByRoute(String routeName) {
        final BusRoute busRoute = busRouteRepository.findByRouteName(routeName).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"No such route found"));;
        return busScheduleRepository.findByBusRoute(busRoute).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"No such route found"));
    }
}
