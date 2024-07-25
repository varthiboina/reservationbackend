package com.example.reservationbus.services.impl;

import com.example.reservationbus.entities.BusRoute;
import com.example.reservationbus.models.ReservationApiException;
import com.example.reservationbus.repos.BusRouteRepository;
import com.example.reservationbus.services.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteServiceImpl implements BusRouteService {

    @Autowired
    private BusRouteRepository busRouteRepository;


    @Override
    public BusRoute addRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    @Override
    public List<BusRoute> getAllBusRoutes() {
        return busRouteRepository.findAll();
    }

    @Override
    public BusRoute getRouteByRouteName(String routeName) {
        return busRouteRepository.findByRouteName(routeName).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"No such route found"));
    }

    @Override
    public BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo) {
        return busRouteRepository.findByCityFromAndCityTo(cityFrom,cityTo).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST,"No such route found"));
    }
}
