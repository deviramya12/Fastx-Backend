package com.springboot.demo.SpringWebAPI.service;



import com.springboot.demo.SpringWebAPI.entity.Bus;
import com.springboot.demo.SpringWebAPI.entity.BusType;
import com.springboot.demo.SpringWebAPI.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BusService {

    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public Bus addBus(Bus bus) {
        if (busRepository.existsByBusNumber(bus.getBusNumber())) {
            throw new RuntimeException("Bus already exists with this number");
        }
        return busRepository.save(bus);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Optional<Bus> getBusById(Long id) {
        return busRepository.findById(id);
    }

    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }
    
    public Bus updateBus(Long id, Bus bus) {
        return busRepository.findById(id).map(existingBus -> {
            existingBus.setBusNumber(bus.getBusNumber());
            existingBus.setBusName(bus.getBusName());
            existingBus.setTotalSeats(bus.getTotalSeats());
            existingBus.setSource(bus.getSource());
            existingBus.setDestination(bus.getDestination());
            existingBus.setArrivalTime(bus.getArrivalTime());
            existingBus.setDepartureTime(bus.getDepartureTime());
            existingBus.setFare(bus.getFare());
            existingBus.setOperatorName(bus.getOperatorName());
            existingBus.setWaterBottle(bus.isWaterBottle());
            existingBus.setChargingPoint(bus.isChargingPoint());
            existingBus.setTv(bus.isTv());
            existingBus.setBlanket(bus.isBlanket());
            existingBus.setBusType(bus.getBusType());
            return busRepository.save(existingBus);
        }).orElseThrow(() -> new RuntimeException("Bus not found with id " + id));
    }
    
    public Bus updateBusPartial(Long id, Map<String, Object> updates) {
        return busRepository.findById(id).map(existingBus -> {
            if (updates.containsKey("busType")) {
                String busTypeStr = (String) updates.get("busType");
                existingBus.setBusType(BusType.valueOf(busTypeStr));
            }
            // Add more fields here if you want to support patching more than busType
            return busRepository.save(existingBus);
        }).orElseThrow(() -> new RuntimeException("Bus not found with id " + id));
    }


}
