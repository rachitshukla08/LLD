package designpatterns.chainofresponsibility.usinginterface;

public class IdleHandler implements RequestHandler{
    @Override
    public void handle(Request request) {
        System.out.println("All the request handlers passed successfully");
    }
}
