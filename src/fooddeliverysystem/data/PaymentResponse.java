package fooddeliverysystem.data;

public class PaymentResponse {
    private final double amount;
    private final int id;
    private final PaymentStatus paymentStatus;

    public PaymentResponse(double amount, int id, PaymentStatus paymentStatus) {
        this.amount = amount;
        this.id = id;
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
