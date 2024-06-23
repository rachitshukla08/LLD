package designpatterns.hard.six_ecommerce.apis;

import designpatterns.hard.six_ecommerce.data.Address;
import designpatterns.hard.six_ecommerce.data.Order;
import designpatterns.hard.six_ecommerce.data.PaymentDetails;
import designpatterns.hard.six_ecommerce.data.User;
import designpatterns.hard.six_ecommerce.order.OrderManager;
import designpatterns.hard.six_ecommerce.order.PaymentProcessor;

public class PlaceOrderAPI {
    private final OrderManager orderManager;

    public PlaceOrderAPI(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public Order placeOrder(User user, PaymentDetails paymentDetails, PaymentProcessor paymentProcessor, Address shippingAdress, Address billingAddress){
        // get place order permission
        return orderManager.placeOrder(user, paymentProcessor, shippingAdress, billingAddress);
    }
}
