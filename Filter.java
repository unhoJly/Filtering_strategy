package com.gridnine.testing;

import com.gridnine.testing.TestClasses.Flight;

import java.util.List;

public class Filter {
    private final Filtering strategy;

    public Filter(Filtering strategy) {
        this.strategy = strategy;
    }

    public void filter(List<Flight> createdFlights) {
        strategy.applyFilter(createdFlights);
    }
}