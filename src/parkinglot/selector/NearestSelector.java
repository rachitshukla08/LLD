package parkinglot.selector;

import parkinglot.data.EntryPoint;
import parkinglot.data.ParkingSpot;

import java.util.List;

public class NearestSelector implements ParkingSpotSelector{
    private final EntryPoint entryPoint;

    public NearestSelector(EntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {
        return null;
    }
}
