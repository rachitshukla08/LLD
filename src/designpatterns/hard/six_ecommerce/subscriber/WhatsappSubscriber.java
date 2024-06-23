package designpatterns.hard.six_ecommerce.subscriber;

public class WhatsappSubscriber implements Subscriber{
    private final String whatsappNumber;

    public WhatsappSubscriber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    @Override
    public void notify(String message) {
        // message on whatsapp
    }
}
