package designpatterns.hard.six_ecommerce.order;

import designpatterns.hard.six_ecommerce.cart.CartManager;
import designpatterns.hard.six_ecommerce.data.Address;
import designpatterns.hard.six_ecommerce.data.Cart;
import designpatterns.hard.six_ecommerce.data.Order;
import designpatterns.hard.six_ecommerce.data.User;




public class OrderManager {
    private final CartManager cartManager;

    public OrderManager(CartManager cartManager) {
        this.cartManager = cartManager;
    }

    public Order placeOrder(User user, PaymentProcessor paymentProcessor, Address shippingAdress, Address billingAddress){
        Cart cart = this.cartManager.getCart(user);
        if(cart.getCartAmount() != paymentProcessor.getPayableAmount()){
            throw new RuntimeException("Invalid amt");
        }

        if(!paymentProcessor.processPayment())
            throw new RuntimeException("Payment failed");
        Order order = new Order(this.generateOrderId(), cart, shippingAdress, billingAddress);
        cartManager.checkoutCart(user, order);
        return order;
    }

    private int generateOrderId(){
        return 0;
    }
}
