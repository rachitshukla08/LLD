package designpatterns.hard.six_ecommerce.data;

import designpatterns.hard.six_ecommerce.database.DBAccessor;
import designpatterns.hard.six_ecommerce.order.OrderState;

public class Order {
    private final int id;
    private final Cart cart;
    private final Address shippingAddress;
    private final Address billingAddress;
    private OrderState orderState;

    public Order(int id, Cart cart, Address shippingAddress, Address billingAddress) {
        this.id = id;
        this.cart = cart;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.orderState = DBAccessor.getOrderState(id);
    }

    public void schedulePickup(PickupDetails pickupDetails){
        this.orderState.schedulePickup(pickupDetails);
    }

    public void cancel(){
        orderState.cancel();
    }

    public void pickup(){
        orderState.pickup();
    }

    public void endTransit(TransitDetails transitDetails){
        orderState.endTransit(transitDetails);
    }

    public OrderStatusDetails getOrderDetails(){
        return this.orderState.getStatus();
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public int getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }
}
