package com.gridnine.testing.filters;

import com.gridnine.testing.Filtering;
import com.gridnine.testing.TestClasses.Flight;

import com.gridnine.testing.TestClasses.Segment;
import java.time.LocalDateTime;
import java.util.List;

public class ArrivalBeforeDeparting implements Filtering {
    LocalDateTime arrival;
    LocalDateTime departure;

    @Override
    public void applyFilter(List<Flight> createdFlights) {
        for (Flight flight : createdFlights) {
            if (flight.getSegments().size() == 1) {
                //Single segment flight
                departure = flight.getSegments().get(0).getDepartureDate();
                arrival = flight.getSegments().get(0).getArrivalDate();

                if (departure.isAfter(arrival)) {
                    System.out.println(flight);
                }
            } else {
                //Multi-segment flight
                List<Segment> segmentList = flight.getSegments();

                for (int i = 0; i < segmentList.size() - 1; i++) {
                    departure = segmentList.get(i).getDepartureDate();
                    arrival = segmentList.get(i).getArrivalDate();
                    LocalDateTime departureNext = segmentList.get(i + 1).getDepartureDate();

                    if (departure.isAfter(arrival) || arrival.isAfter(departureNext)) {
                        System.out.println(flight);
                    }
                }
            }
        }
    }
}