package domain;

import api.ID;

import java.util.Set;

public class Product extends BaseAggregateRoot {
    private ID productID;
    private Money price;
    private Set<String> tags;

    public Product(ID productID, Money price, Set<String> tags) {
        this.productID = productID;
        this.price = price;
        this.tags = tags;
    }

    public ID getProductID() {
        return productID;
    }

    public Money getPrice() {
        return price;
    }

    public Set<String> getTags() {
        return tags;
    }
}
