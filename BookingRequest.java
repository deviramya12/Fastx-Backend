package com.springboot.demo.SpringWebAPI.dto;


public class BookingRequest {

    private Long busId;
    private int seatCount;
    private String paymentMode;

    // Optional: Add bookingDate or totalPrice if needed

    // Getters and Setters
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
}
