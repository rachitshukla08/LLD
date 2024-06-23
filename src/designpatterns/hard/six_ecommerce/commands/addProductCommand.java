package designpatterns.hard.six_ecommerce.commands;

import designpatterns.hard.six_ecommerce.data.ProductCopy;
import designpatterns.hard.six_ecommerce.data.User;

public class addProductCommand implements Command{
    private final User user;
    private final ProductCopy productCopy;

    public addProductCommand(User user, ProductCopy productCopy) {
        this.user = user;
        this.productCopy = productCopy;
    }

    @Override
    public void execute() {

    }
}
