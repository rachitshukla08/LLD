package parkinglot.payments;

import parkinglot.data.Ticket;
import parkinglot.factory.VehicleTypeManagerFactory;
import parkinglot.manager.VehicleTypeManager;

public class ParkingFeeProcessor {
    public double getParkingFees(Ticket ticket){
        double duration=0;
        //Figure out duration
        VehicleTypeManager vehicleTypeManager = VehicleTypeManagerFactory
                .getVehicleTypeManager(ticket.getVehicle().getVehicleType());
        return vehicleTypeManager.getParkingFees(duration);
    }

    public boolean processParkingFee(Ticket ticket, PaymentProcessor paymentProcessor){
        if(getParkingFees(ticket)!=paymentProcessor.getAmount())
            throw new RuntimeException("Invalid amount payment");
        return paymentProcessor.executePayment();
    }
}
