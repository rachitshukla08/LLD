package designpatterns.chainofresponsibility.usinginterface;

public class AuthenticationHandler implements RequestHandler{
    private final RequestHandler nextHandler;
    private final TokenManager tokenManager;

    public AuthenticationHandler(RequestHandler nextHandler, TokenManager tokenManager) {
        this.nextHandler = nextHandler;
        this.tokenManager = tokenManager;
    }

    @Override
    public void handle(Request request) {
        String email = this.tokenManager.getEmailFromToken(request.getToken());
        if(!isValidEmail(email))
            throw new RuntimeException("Invalid email");
        System.out.println("Authentication passed");
        nextHandler.handle(request);
    }

    private boolean isValidEmail(String email){
        //Checks validity
        return true;
    }
}
