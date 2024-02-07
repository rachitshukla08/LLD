package designpatterns.chainofresponsibility.usinginterface.factory;

import designpatterns.chainofresponsibility.usinginterface.*;

public class RequestHandlerFactory {
    private RequestHandlerFactory(){}

    public static RequestHandler getHandler(String apiName) {
        return new ValidationHandler(new AuthenticationHandler(
                new AuthorizationHandler(new IdleHandler(), new UserManager()),
                new TokenManager()
        ));
    }
}
