package fooddeliverysystem.permission;

import fooddeliverysystem.data.User;

public class CheckoutCartPermission implements Permission{
    private final User user;

    public CheckoutCartPermission(User user) {
        this.user = user;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
