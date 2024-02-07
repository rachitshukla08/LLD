package designpatterns.chainofresponsibility.usinginterface;

public class ValidationHandler implements RequestHandler{
    private final RequestHandler nextHandler;

    public ValidationHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(Request request) {
        if(request.getHeader() == null || request.getHeader().isEmpty())
            throw new RuntimeException("Bad request headers");
        if(request.getBody() == null || request.getBody().isEmpty())
            throw new RuntimeException("Bad request body");
        System.out.println("Validation passed");
        this.nextHandler.handle(request);
    }
}
