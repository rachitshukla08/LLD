package designpatterns.hard.six_ecommerce.subscriber;

public class EmailSubscriber implements Subscriber{
    private final String emailId;

    public EmailSubscriber(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void notify(String message) {
        //send email
    }
}
