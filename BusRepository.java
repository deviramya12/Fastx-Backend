package com.springboot.demo.SpringWebAPI.repository;



import com.springboot.demo.SpringWebAPI.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
    boolean existsByBusNumber(String busNumber);
}
