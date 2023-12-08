package christmas.model;

public interface EventPolicy {
    boolean isSatisfy(Reservation reservation);

    int calculateDiscount();


}