package domain;

public class DiscountItemsCountPolicy implements DiscountPolicy {

    int minAmount;
    int discountPercent;

    @Override
    public Offer apply(Offer offer) {
        if(offer.itemsCount() >= minCount) {
            Set<Product> discountedProducts = offer.products.map((p) -> p.withDiscount(discountPercent));
            return new Offer(discountedProducts);
        }
        else {
            return offer;
        }
    }
}
