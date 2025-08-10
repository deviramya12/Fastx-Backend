package com.springboot.demo.SpringWebAPI.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;  // assuming payment links to booking by ID

    private Double amount;

    private String paymentMethod;

    private String status;
    
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Long id, Long bookingId, Double amount, String paymentMethod, String status,
			LocalDateTime paymentDate) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.paymentDate = paymentDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
    
}
