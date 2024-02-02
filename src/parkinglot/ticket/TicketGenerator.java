package parkinglot.ticket;

import parkinglot.data.ParkingSpot;
import parkinglot.data.Ticket;
import parkinglot.data.Vehicle;

public class TicketGenerator {
    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        String ticketNo = getUniqueTicketNumber();
        return new Ticket(ticketNo, vehicle, parkingSpot);
    }

    private String getUniqueTicketNumber(){
        return "";
    }
}
