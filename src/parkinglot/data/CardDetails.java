package parkinglot.data;

public class CardDetails {
    private final String name;
    private final int pin;
    private final String cardNumber;

    public CardDetails(String name, int pin, String cardNumber) {
        this.name = name;
        this.pin = pin;
        this.cardNumber = cardNumber;
    }
}
