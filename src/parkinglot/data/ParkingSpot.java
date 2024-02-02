package parkinglot.data;

public class ParkingSpot {
    private final String floorNo;
    private final VehicleType vehicleType;
    private final String name;
    private boolean isFree;

    public ParkingSpot(String floorNo, VehicleType vehicleType, String name, boolean isFree) {
        this.floorNo = floorNo;
        this.vehicleType = vehicleType;
        this.name = name;
        this.isFree = isFree;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getName() {
        return name;
    }

    public boolean isFree() {
        return isFree;
    }
}
