package designpatterns.hard.six_ecommerce.order;

public interface PaymentProcessor {
    boolean processPayment();
    double getPayableAmount();
}
