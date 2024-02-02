package parkinglot.apis;

import parkinglot.data.CardDetails;
import parkinglot.data.PaymentMode;
import parkinglot.data.Ticket;
import parkinglot.factory.PaymentProcessorFactory;
import parkinglot.payments.ParkingFeeProcessor;
import parkinglot.payments.PaymentProcessor;

import java.util.Map;

public class PayParkingFees {
    public boolean payParkingFee(Ticket ticket, PaymentMode paymentMode, Map<String, String> paymentDetails){
        PaymentProcessor paymentProcessor = null;
        double amount = Double.parseDouble(paymentDetails.get("amount"));
        if(paymentMode.equals(PaymentMode.CARD)){
            CardDetails cardDetails = null;
            paymentProcessor = PaymentProcessorFactory.getCardBasedPaymentProcessor(amount, cardDetails);
        }
        else if(paymentMode.equals(PaymentMode.CASH)){
            paymentProcessor = PaymentProcessorFactory.getCashBasedPaymentProcessor(amount);
        }
        else
            throw new IllegalArgumentException("Illegal payment mode");
        return new ParkingFeeProcessor().processParkingFee(ticket, paymentProcessor);
    }
}

