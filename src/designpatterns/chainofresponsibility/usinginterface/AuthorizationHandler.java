package designpatterns.chainofresponsibility.usinginterface;

public class AuthorizationHandler implements RequestHandler{
    private final RequestHandler nextHandler;
    private final UserManager userManager;
    public AuthorizationHandler(RequestHandler nextHandler, UserManager userManager) {
        this.nextHandler = nextHandler;
        this.userManager = userManager;
    }

    @Override
    public void handle(Request request) {
        if(!userManager.isSubscribed(request.getToken()))
            throw new RuntimeException("User not subscribed");
        System.out.println("Authorization passed");
        this.nextHandler.handle(request);
    }
}
