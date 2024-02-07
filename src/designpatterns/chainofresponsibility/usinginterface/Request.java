package designpatterns.chainofresponsibility.usinginterface;

public class Request {

    String getHeader(){
        return "h";
    }

    String getBody(){
        return "b";
    }

    String getToken(){
        return "token";
    }
}
