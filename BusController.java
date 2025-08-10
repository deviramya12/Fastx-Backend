package com.springboot.demo.SpringWebAPI.controller;

import com.springboot.demo.SpringWebAPI.entity.Bus;
import com.springboot.demo.SpringWebAPI.service.BusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/bus")
@CrossOrigin
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
        return ResponseEntity.ok(busService.addBus(bus));
    }

    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        return ResponseEntity.ok(busService.getAllBuses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        return busService.getBusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return ResponseEntity.ok("Bus deleted successfully");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus bus) {
        Bus updatedBus = busService.updateBus(id, bus);
        return ResponseEntity.ok(updatedBus);
    }
    
    @PatchMapping("/bus/{id}")
    public Bus patchBus(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return busService.updateBusPartial(id, updates);
    }
}
