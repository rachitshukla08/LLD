package fooddeliverysystem.permission;

import fooddeliverysystem.data.User;

public class PlaceOrderPermission implements Permission{
    private final User user;

    public PlaceOrderPermission(User user) {
        this.user = user;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
