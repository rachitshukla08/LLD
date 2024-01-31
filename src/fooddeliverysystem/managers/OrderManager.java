package fooddeliverysystem.managers;

import fooddeliverysystem.data.*;
import fooddeliverysystem.factory.PermissionFactory;
import fooddeliverysystem.permission.Permission;
import fooddeliverysystem.permission.UpdateOrderPermission;

import java.util.List;

public class OrderManager {
    public Order placeOrder(User user) {
        Permission permission = PermissionFactory.getPlaceOrderPermission(user);
        if(!permission.isPermitted())
            throw new RuntimeException("Permission denied");
        CartManager cartManager = new CartManager();
        List<CartItem> cartItems = cartManager.getUserCart(user);
        int orderId = DataAccessor.createOrder(user, cartItems);
        cartManager.checkOutUserCart(user);
        return new Order(cartItems, orderId, user.getId(), OrderStatus.ORDER_PLACED);
    }

    public List<Order> getOrders(User user) {
        return null;
    }

    public Order getOrder(int orderId){
        return null;
    }

    public void setOrderToCooking(User user, Order order) {
        // This will check if the user is the admin of the restaurant where the order is placed
        Permission permission = PermissionFactory.getUpdateOrderPermission(user, order, order.getOrderStatus());
        if(!permission.isPermitted())
            throw new RuntimeException("Not permitted to change status");
        if(!order.getOrderStatus().equals(OrderStatus.ORDER_PLACED))
            throw new RuntimeException("Only ORDER_PLACED can be set to COOKING");
        DataAccessor.updateOrderStatus(order, order.getOrderStatus());
    }

    public void setOrderToReadyForDelivery(User user, Order order){
        Permission permission = PermissionFactory.getUpdateOrderPermission(user, order, order.getOrderStatus());
        if(!permission.isPermitted())
            throw new RuntimeException("Not permitted to change status");
        if(!order.getOrderStatus().equals(OrderStatus.COOKING))
            throw new RuntimeException("Only COOKING can be set to READY_FOR_DELIVERY");
    }

    public void setOrderToOutForDelivery(User user, Order order) {
        Permission permission = PermissionFactory.getUpdateOrderPermission(user, order, order.getOrderStatus());
        if(!permission.isPermitted())
            throw new RuntimeException("Not permitted to change status");
        if(!order.getOrderStatus().equals(OrderStatus.READY_FOR_DELIVERY))
            throw new RuntimeException("Only READY_FOR_DELIVERY can be set to OUT_FOR_DELIVERY");
    }

    public void setOrderToCancelled(User user, Order order) {
        Permission permission = PermissionFactory.getUpdateOrderPermission(user, order, order.getOrderStatus());
        if(!permission.isPermitted())
            throw new RuntimeException("Not permitted to change status");
        if(!order.getOrderStatus().equals(OrderStatus.ORDER_PLACED))
            throw new RuntimeException("Not permitted to cancel order");
    }

    // TO GET RID OF THESE IF CHECKS WE CAN USE STATE DESIGN PATTERN
}
