package designpatterns.hard.six_ecommerce.order;

import designpatterns.hard.six_ecommerce.data.DeliveryDetails;
import designpatterns.hard.six_ecommerce.data.OrderStatusDetails;
import designpatterns.hard.six_ecommerce.data.PickupDetails;
import designpatterns.hard.six_ecommerce.data.TransitDetails;

public interface OrderState {
    public void schedulePickup(PickupDetails pickupDetails);
    public void pickup();
    public void endTransit(TransitDetails transitDetails);
    public void scheduleDelivery(DeliveryDetails deliveryDetails);
    public void deliver();
    public void cancel();
    public OrderStatusDetails getStatus();

}
