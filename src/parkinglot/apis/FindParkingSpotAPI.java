package parkinglot.apis;

import parkinglot.data.EntryPoint;
import parkinglot.data.ParkingSpot;
import parkinglot.data.SpotSelection;
import parkinglot.data.VehicleType;
import parkinglot.factory.SpotSelectorFactory;
import parkinglot.factory.VehicleTypeManagerFactory;
import parkinglot.finder.ParkingSpotFinder;
import parkinglot.manager.VehicleTypeManager;
import parkinglot.selector.ParkingSpotSelector;

public class FindParkingSpotAPI {
    public ParkingSpot findParkingSpot(EntryPoint entryPoint, VehicleType vehicleType, SpotSelection spotSelection){
        VehicleTypeManager vehicleTypeManager = VehicleTypeManagerFactory.getVehicleTypeManager(vehicleType);
        ParkingSpotSelector parkingSpotSelector = null;
        if(spotSelection.equals(SpotSelection.RANDOM)){
            parkingSpotSelector = SpotSelectorFactory.getRandomSelector();
        }
        else if(spotSelection.equals(SpotSelection.NEAREST)){
            parkingSpotSelector = SpotSelectorFactory.getNearestSelector(entryPoint);
        }
        else {
            throw new IllegalArgumentException();
        }
        return new ParkingSpotFinder(vehicleTypeManager, parkingSpotSelector).findParkingSpot();
    }
}
