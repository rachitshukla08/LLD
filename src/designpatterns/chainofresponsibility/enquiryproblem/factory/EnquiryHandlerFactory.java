package designpatterns.chainofresponsibility.enquiryproblem.factory;

import designpatterns.chainofresponsibility.enquiryproblem.handlers.*;

public class EnquiryHandlerFactory {
    private EnquiryHandlerFactory(){}

    public static EnquiryHandler getEnquiryHandler(String api){
        return new LogHandler(new AcademicEnquiryHandler(new ProjectEnquiryHandler(new SubscriptionsHandler(new UnknownHandler()))));
    }
}
