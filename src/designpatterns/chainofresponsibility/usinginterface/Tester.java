package designpatterns.chainofresponsibility.usinginterface;

import designpatterns.chainofresponsibility.usinginterface.PlayVideoAPI;
import designpatterns.chainofresponsibility.usinginterface.Request;
import designpatterns.chainofresponsibility.usinginterface.factory.RequestHandlerFactory;

public class Tester {
    public static void main(String[] args) {
        RequestHandlerFactory.getHandler("playVideoAPI").handle(new Request());
    }
}
