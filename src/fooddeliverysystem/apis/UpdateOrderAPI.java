package fooddeliverysystem.apis;

import fooddeliverysystem.data.Order;
import fooddeliverysystem.data.OrderStatus;
import fooddeliverysystem.data.User;
import fooddeliverysystem.managers.OrderManager;
import fooddeliverysystem.managers.UserManager;

public class UpdateOrderAPI {
    UserManager userManager = new UserManager();
    OrderManager orderManager = new OrderManager();
    public void updateOrder(int orderId, OrderStatus status, String userToken){
        //Validations
        User user = userManager.getUserByToken(userToken);
        if(user==null)
            throw new RuntimeException("Invalid token");
        Order order = orderManager.getOrder(orderId);
        if(order == null)
            throw new RuntimeException("Invalid token");
        if(status.equals(OrderStatus.COOKING))
            orderManager.setOrderToCooking(user, order);
        else if(status.equals(OrderStatus.READY_FOR_DELIVERY))
            orderManager.setOrderToReadyForDelivery(user, order);
        // And other conditions
    }
}
