package parkinglot.apis;

import parkinglot.data.Ticket;
import parkinglot.factory.VehicleTypeManagerFactory;
import parkinglot.payments.ParkingFeeProcessor;
import parkinglot.payments.PaymentProcessor;

public class GetParkingFeeAPI {
    public double getParkingFee(Ticket ticket){
        return new ParkingFeeProcessor().getParkingFees(ticket);
    }

}
