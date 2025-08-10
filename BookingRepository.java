package com.springboot.demo.SpringWebAPI.repository;


import com.springboot.demo.SpringWebAPI.entity.Booking;
import com.springboot.demo.SpringWebAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
}
