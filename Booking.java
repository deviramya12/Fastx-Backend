package com.springboot.demo.SpringWebAPI.entity;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bus_id")
    private Long busId;
    @Column(name = "seat_count")
    private int seatCount;
    @Column(name = "payment_mode")
    private String paymentMode;

    private String status; // e.g., CONFIRMED, CANCELLED
    
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "booking_date")
    private String bookingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public Booking() {}

    public Booking(Long id, Long busId, int seatCount, String paymentMode, String status,
                   double totalPrice, String bookingDate, User user) {
        this.id = id;
        this.busId = busId;
        this.seatCount = seatCount;
        this.paymentMode = paymentMode;
        this.status = status;
        this.totalPrice = totalPrice;
        this.bookingDate = bookingDate;
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
