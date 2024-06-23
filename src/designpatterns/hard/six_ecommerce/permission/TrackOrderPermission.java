package designpatterns.hard.six_ecommerce.permission;

import designpatterns.hard.six_ecommerce.data.Order;
import designpatterns.hard.six_ecommerce.data.User;

public class TrackOrderPermission implements Permission{
    private final User user;
    private final Order order;

    public TrackOrderPermission(User user, Order order) {
        this.user = user;
        this.order = order;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
