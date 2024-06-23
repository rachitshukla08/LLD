package designpatterns.hard.six_ecommerce.apis;

import designpatterns.hard.six_ecommerce.data.Order;
import designpatterns.hard.six_ecommerce.data.OrderStatusDetails;
import designpatterns.hard.six_ecommerce.data.User;
import designpatterns.hard.six_ecommerce.database.DBAccessor;
import designpatterns.hard.six_ecommerce.permission.Permission;
import designpatterns.hard.six_ecommerce.permission.PermissionFactory;

import java.util.Optional;

public class TrackOrderAPI {
    public OrderStatusDetails trackOrder(int orderId, User user){
        Order order = DBAccessor.getOrderByOrderId(orderId);
        if(order == null)
            throw new RuntimeException();
        Optional<Permission> permission = PermissionFactory.getTrackOrderPermission(user, order);
        if(!permission.isPresent() || !permission.get().isPermitted())
            throw new RuntimeException("Not permitted to track order");
        return order.getOrderDetails();
    }
}
