package designpatterns.chainofresponsibility.enquiryproblem;

import designpatterns.chainofresponsibility.enquiryproblem.data.Response;
import designpatterns.chainofresponsibility.enquiryproblem.factory.EnquiryHandlerFactory;

public class HandleEnquiryAPI {
    public Response handleEnquiry(String enquiry) {
        EnquiryHandlerFactory.getEnquiryHandler("handleEnquiryAPI").handle(enquiry);
        return new Response();
    }
}
