package parkinglot.data;

public class Ticket {
    private final String referenceNo;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public Ticket(String referenceNo, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.referenceNo = referenceNo;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
