package parkinglot.apis;

import parkinglot.data.ParkingSpot;
import parkinglot.vacator.ParkingSpotVacator;

public class VacateParkingSpotAPI {

    public void vacateParkingSpot(ParkingSpot parkingSpot){
        new ParkingSpotVacator().vacateParkingSpot(parkingSpot);
    }
}
