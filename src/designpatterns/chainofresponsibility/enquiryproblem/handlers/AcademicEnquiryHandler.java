package designpatterns.chainofresponsibility.enquiryproblem.handlers;

import designpatterns.chainofresponsibility.enquiryproblem.data.EnquiryType;

public class AcademicEnquiryHandler implements EnquiryHandler {

    private final EnquiryHandler nextHandler;

    public AcademicEnquiryHandler(EnquiryHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public EnquiryType handle(String enquiry) {
        System.out.println("Trying to process query through academic handler");
        if(enquiry.contains("DSA")||enquiry.contains("DESIGN")){
            // Take actions
            return EnquiryType.ACADEMIC;
        }
        return nextHandler.handle(enquiry);
    }
}
