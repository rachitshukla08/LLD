package designpatterns.hard.six_ecommerce.subscriber;

public class SMSSubscriber implements Subscriber{
    private final String number;

    public SMSSubscriber(String number) {
        this.number = number;
    }

    @Override
    public void notify(String message) {

    }
}
