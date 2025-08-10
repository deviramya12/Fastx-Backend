package com.springboot.demo.SpringWebAPI.service;



import com.springboot.demo.SpringWebAPI.entity.Route;
import com.springboot.demo.SpringWebAPI.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    // Create or update a route
    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    // Get all routes
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    // Get route by id
    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    // Delete route by id
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
