package com.example.reservationbus.controller;


import com.example.reservationbus.entities.Bus;
import com.example.reservationbus.models.ResponseModel;
import com.example.reservationbus.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    @Autowired
    public BusService busService;

    @PostMapping("/add")
    public ResponseModel<Bus> addBus(@RequestBody Bus bus)
    {
        final Bus savedBus = busService.addBus(bus);
        return new ResponseModel<>(HttpStatus.OK.value(),"Bus saved" , savedBus);
    }
    @GetMapping("/all")
    public List<Bus> getAll()
    {

        return busService.getAllBus();
    }


}
