package designpatterns.chainofresponsibility.enquiryproblem.handlers;

import designpatterns.chainofresponsibility.enquiryproblem.data.EnquiryType;

public class UnknownHandler implements EnquiryHandler{
    @Override
        public EnquiryType handle(String enquiry) {
        System.out.println("Couldnt find relevent handler");
        return EnquiryType.UNKNOWN;
    }
}
