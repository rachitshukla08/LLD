package designpatterns.chainofresponsibility.usinginterface;

import designpatterns.chainofresponsibility.usinginterface.factory.RequestHandlerFactory;

import java.util.List;

public class PlayVideoAPI {
    //private final List<RequestHandler> requestHandlers;

    //public PlayVideoAPI(List<RequestHandler> requestHandlers) {
        //this.requestHandlers = requestHandlers;
    //}

    public void playVideo(Request request){
//        handle(request);
        RequestHandlerFactory.getHandler("playVideoAPI").handle(request);
        System.out.println("All handlers passed now executing API");
    }

//    public void handle(Request request){
//        for(RequestHandler requestHandler: requestHandlers){
//            requestHandler.handle(request);
//        }
//    }
}
