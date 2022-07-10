package com.gridnine.testing;

import com.gridnine.testing.TestClasses.FlightBuilder;
import com.gridnine.testing.filters.ArrivalBeforeDeparting;
import com.gridnine.testing.filters.DepartingBeforeNow;
import com.gridnine.testing.filters.More2HrsNonFlight;

public class Main {
    public static void main(String[] args) {
        Filter filter;

        //Вылеты до текущего момента времени
        System.out.println();
        filter = new Filter(new DepartingBeforeNow());
        filter.filter(FlightBuilder.createFlights());

        //На маршруте есть сегменты с датой прилёта раньше даты вылета
        System.out.println();
        filter = new Filter(new ArrivalBeforeDeparting());
        filter.filter(FlightBuilder.createFlights());

        //Общее время, проведённое на земле, превышает два часа
        System.out.println();
        filter = new Filter(new More2HrsNonFlight());
        filter.filter(FlightBuilder.createFlights());
    }
}