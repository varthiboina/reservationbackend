package com.example.reservationbus.controller;

import com.example.reservationbus.entities.BusRoute;
import com.example.reservationbus.entities.BusSchedule;
import com.example.reservationbus.models.ResponseModel;
import com.example.reservationbus.services.BusScheduleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/busSchedule")
public class BusScheduleController {

    @Autowired
    private BusScheduleService busScheduleService;

    @PostMapping("/add")
    public ResponseModel<BusSchedule> addSchedule(@RequestBody BusSchedule busSchedule)
    {
        final BusSchedule schedule = busScheduleService.addSchedule(busSchedule);
        return new ResponseModel<>(HttpStatus.OK.value(), "added schedule" , schedule);
    }
    @GetMapping("/all")
    public ResponseEntity<List<BusSchedule>> getAllBusSchedule()
    {
        return ResponseEntity.ok(busScheduleService.getAllBusSchedule());
    }
    @GetMapping("/{routeName}")
    public ResponseEntity<List<BusSchedule>> getBusScheduleByRouteByName(@PathVariable(name = "routeName") String routeName)
    {
        return ResponseEntity.ok(busScheduleService.getSchedulesByRoute(routeName));
    }


}
