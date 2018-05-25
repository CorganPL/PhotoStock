package domain;

public interface DiscountPolicy {
    Offer apply(Offer offer);
}
