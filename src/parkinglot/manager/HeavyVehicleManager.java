package parkinglot.manager;

import parkinglot.data.ParkingSpot;

import java.util.List;

public class HeavyVehicleManager implements VehicleTypeManager{
    @Override
    public List<ParkingSpot> getParkingSpots() {
        return null;
    }

    @Override
    public double getParkingFees(double durationInHours) {
        return 0;
    }
}
