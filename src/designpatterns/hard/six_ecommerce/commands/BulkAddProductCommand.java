package designpatterns.hard.six_ecommerce.commands;

import designpatterns.hard.six_ecommerce.data.ProductCopy;
import designpatterns.hard.six_ecommerce.data.User;

import java.util.List;

public class BulkAddProductCommand implements Command{
    private final User user;
    private final List<ProductCopy> products;

    public BulkAddProductCommand(User user, List<ProductCopy> products) {
        this.user = user;
        this.products = products;
    }

    @Override
    public void execute() {

    }
}
