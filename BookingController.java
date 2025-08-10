package com.springboot.demo.SpringWebAPI.controller;


import com.springboot.demo.SpringWebAPI.dto.BookingRequest;
import com.springboot.demo.SpringWebAPI.entity.Booking;
import com.springboot.demo.SpringWebAPI.service.BookingService;
import com.springboot.demo.SpringWebAPI.config.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;
    private final JwtUtil jwtUtil;

    public BookingController(BookingService bookingService, JwtUtil jwtUtil) {
        this.bookingService = bookingService;
        this.jwtUtil = jwtUtil;
    }

    private String getEmailFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        return jwtUtil.extractEmail(token);
    }

    @PostMapping
    public ResponseEntity<Booking> book(@RequestBody BookingRequest request, HttpServletRequest servletRequest) {
        String email = getEmailFromRequest(servletRequest);
        Booking booking = bookingService.bookTicket(email, request);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Booking>> myBookings(HttpServletRequest request) {
        String email = getEmailFromRequest(request);
        return ResponseEntity.ok(bookingService.getBookingsByUser(email));
    }
  

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id, HttpServletRequest request) {
        String email = getEmailFromRequest(request);
        bookingService.cancelBooking(id, email);
        return ResponseEntity.ok().build();
    }
}
