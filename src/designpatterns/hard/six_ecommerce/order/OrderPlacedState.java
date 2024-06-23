package designpatterns.hard.six_ecommerce.order;

import designpatterns.hard.six_ecommerce.data.DeliveryDetails;
import designpatterns.hard.six_ecommerce.data.OrderStatusDetails;
import designpatterns.hard.six_ecommerce.data.PickupDetails;
import designpatterns.hard.six_ecommerce.data.TransitDetails;

public class OrderPlacedState implements OrderState{
    @Override
    public void schedulePickup(PickupDetails pickupDetails) {

    }

    @Override
    public void pickup() {

    }

    @Override
    public void endTransit(TransitDetails transitDetails) {

    }

    @Override
    public void scheduleDelivery(DeliveryDetails deliveryDetails) {

    }

    @Override
    public void deliver() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public OrderStatusDetails getStatus() {
        return null;
    }
}
