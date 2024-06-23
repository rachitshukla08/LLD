package designpatterns.hard.six_ecommerce.data;

import designpatterns.hard.six_ecommerce.order.OrderStatus;

public class OrderStatusDetails {
    private OrderStatus orderStatus;
    private final String description;

    public OrderStatusDetails(OrderStatus orderStatus, String description) {
        this.orderStatus = orderStatus;
        this.description = description;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getDescription() {
        return description;
    }
}
