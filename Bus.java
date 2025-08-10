package com.springboot.demo.SpringWebAPI.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String busNumber;

    private String busName;

    private int totalSeats;

    private String source;

    private String destination;

    private String arrivalTime;

    private String departureTime;

    private double fare;

    private String operatorName;

    private boolean waterBottle;
    private boolean chargingPoint;
    private boolean tv;
    private boolean blanket;

    @Enumerated(EnumType.STRING)
    private BusType busType;

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(Long id, String busNumber, String busName, int totalSeats, String source, String destination,
			String arrivalTime, String departureTime, double fare, String operatorName, boolean waterBottle,
			boolean chargingPoint, boolean tv, boolean blanket, BusType busType) {
		super();
		this.id = id;
		this.busNumber = busNumber;
		this.busName = busName;
		this.totalSeats = totalSeats;
		this.source = source;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.fare = fare;
		this.operatorName = operatorName;
		this.waterBottle = waterBottle;
		this.chargingPoint = chargingPoint;
		this.tv = tv;
		this.blanket = blanket;
		this.busType = busType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public boolean isWaterBottle() {
		return waterBottle;
	}

	public void setWaterBottle(boolean waterBottle) {
		this.waterBottle = waterBottle;
	}

	public boolean isChargingPoint() {
		return chargingPoint;
	}

	public void setChargingPoint(boolean chargingPoint) {
		this.chargingPoint = chargingPoint;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isBlanket() {
		return blanket;
	}

	public void setBlanket(boolean blanket) {
		this.blanket = blanket;
	}

	public BusType getBusType() {
		return busType;
	}

	public void setBusType(BusType busType) {
		this.busType = busType;
	}
    
}


