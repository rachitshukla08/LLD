package parkinglot.factory;

import parkinglot.data.VehicleType;
import parkinglot.manager.FourWheelerManager;
import parkinglot.manager.HeavyVehicleManager;
import parkinglot.manager.TwoWheelerManager;
import parkinglot.manager.VehicleTypeManager;

public class VehicleTypeManagerFactory {
    private VehicleTypeManagerFactory(){}

    public static VehicleTypeManager getVehicleTypeManager(VehicleType vehicleType) {
        VehicleTypeManager vehicleTypeManager = null;
        if(vehicleType.equals(VehicleType.TWO_WHEELER))
            vehicleTypeManager = new TwoWheelerManager();
        else if(vehicleType.equals(VehicleType.FOUR_WHEELER))
            vehicleTypeManager = new FourWheelerManager();
        else if(vehicleType.equals(VehicleType.HEAVY))
            vehicleTypeManager = new HeavyVehicleManager();
        return vehicleTypeManager;
    }
}
