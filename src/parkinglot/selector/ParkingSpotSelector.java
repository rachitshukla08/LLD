package parkinglot.selector;

import parkinglot.data.ParkingSpot;

import java.util.List;

public interface ParkingSpotSelector {
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots);
}
