package com.example.reservationbus.controller;

import com.example.reservationbus.entities.Bus;
import com.example.reservationbus.entities.BusRoute;
import com.example.reservationbus.models.ResponseModel;
import com.example.reservationbus.services.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/route")
public class BusRouteController {

    @Autowired
    private BusRouteService busRouteService;


    @PostMapping("/add")
    public ResponseModel<BusRoute> addRoute(@RequestBody BusRoute busRoute)
    {
        final BusRoute busRoute1 =  busRouteService.addRoute(busRoute);
        return new ResponseModel<>(HttpStatus.OK.value(),"BusRoute saved" , busRoute1);
    }
    @GetMapping("/all")
    public ResponseEntity<List<BusRoute>> getAllRoutes()
    {

        return ResponseEntity.ok(busRouteService.getAllBusRoutes());
    }

    @GetMapping("/{routeName}")
    public ResponseEntity<BusRoute> getBusRouteByName(@PathVariable (name = "routeName") String routeName)
    {
        return ResponseEntity.ok(busRouteService.getRouteByRouteName(routeName));
    }

    @GetMapping("/query")
    public ResponseEntity<BusRoute> getBusRouteByCityFromAndCityTo(
            @RequestParam String cityFrom , @RequestParam String cityTo

    )
    {
        return ResponseEntity.ok(busRouteService.getRouteByCityFromAndCityTo(cityFrom,cityTo));
    }
}
