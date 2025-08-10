package com.springboot.demo.SpringWebAPI.service;


import com.springboot.demo.SpringWebAPI.dto.BookingRequest;
import com.springboot.demo.SpringWebAPI.entity.Booking;
import com.springboot.demo.SpringWebAPI.entity.User;
import com.springboot.demo.SpringWebAPI.repository.BookingRepository;
import com.springboot.demo.SpringWebAPI.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;

    public BookingService(BookingRepository bookingRepo, UserRepository userRepo) {
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
    }

    public Booking bookTicket(String email, BookingRequest request) {
        User user = userRepo.findByEmail(email).orElseThrow();

        Booking booking = new Booking(); // no builder
        booking.setBusId(request.getBusId());
        booking.setSeatCount(request.getSeatCount());
        booking.setPaymentMode(request.getPaymentMode());
        booking.setStatus("CONFIRMED");
        booking.setUser(user);

        return bookingRepo.save(booking);
    }

    public List<Booking> getBookingsByUser(String email) {
        User user = userRepo.findByEmail(email).orElseThrow();
        return bookingRepo.findByUser(user);
    }

    public void cancelBooking(Long id, String email) {
        Booking booking = bookingRepo.findById(id).orElseThrow();
        if (!booking.getUser().getEmail().equals(email)) {
            throw new RuntimeException("Unauthorized to cancel");
        }
        bookingRepo.delete(booking);
    }
}
