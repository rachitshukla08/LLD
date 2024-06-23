package designpatterns.hard.six_ecommerce.permission;

import designpatterns.hard.six_ecommerce.data.User;

public class SearchProductPermission implements Permission{
    private final User user;

    public SearchProductPermission(User user){
        this.user = user;
    }
    @Override
    public boolean isPermitted() {
        return true;
    }
}
