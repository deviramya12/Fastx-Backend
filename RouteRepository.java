package com.springboot.demo.SpringWebAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.SpringWebAPI.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
	
}

