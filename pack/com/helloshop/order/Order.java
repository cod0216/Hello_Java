package pack.com.helloshop.order;

import pack.com.helloshop.product.Product;
import pack.com.helloshop.user.User;

public class Order {

    User user;
    Product product;
    public Order(User user, Product product) {
        this.user = user;
        this.product = product;
    }
}
