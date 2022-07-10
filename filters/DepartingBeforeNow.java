package com.gridnine.testing.filters;

import com.gridnine.testing.Filtering;
import com.gridnine.testing.TestClasses.Flight;

import java.time.LocalDateTime;
import java.util.List;

public class DepartingBeforeNow implements Filtering {
    @Override
    public void applyFilter(List<Flight> createdFlights) {
        createdFlights.stream()
                .filter(x -> x.getSegments().stream()
                        .anyMatch(y -> y.getDepartureDate().isBefore(LocalDateTime.now())))
                .forEach(System.out::println);
    }
}