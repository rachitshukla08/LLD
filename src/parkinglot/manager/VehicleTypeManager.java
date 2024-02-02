package parkinglot.manager;

import parkinglot.data.ParkingSpot;

import java.util.List;

public interface VehicleTypeManager {
    public List<ParkingSpot> getParkingSpots();
    public double getParkingFees(double durationInHours);
}
