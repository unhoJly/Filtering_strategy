package com.gridnine.testing.filters;

import com.gridnine.testing.Filtering;
import com.gridnine.testing.TestClasses.Flight;

import com.gridnine.testing.TestClasses.Segment;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class More2HrsNonFlight implements Filtering {
    @Override
    public void applyFilter(List<Flight> createdFlights) {
        for (Flight flight : createdFlights) {
            List<Segment> segments = flight.getSegments();

            if (segments.size() > 1) {
                long groundTime = 0;

                for (int i = 0; i < segments.size() - 1; i++) {
                    LocalDateTime arrival = segments.get(i).getArrivalDate();
                    LocalDateTime department = segments.get(i + 1).getDepartureDate();
                    groundTime += arrival.until(department, ChronoUnit.HOURS);
                }

                if (groundTime > 2) {
                    System.out.println(flight);
                }
            }
        }
    }
}