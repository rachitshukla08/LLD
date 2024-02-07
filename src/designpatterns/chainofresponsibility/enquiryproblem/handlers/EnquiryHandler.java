package designpatterns.chainofresponsibility.enquiryproblem.handlers;

import designpatterns.chainofresponsibility.enquiryproblem.data.EnquiryType;

public interface EnquiryHandler {
    EnquiryType handle(String enquiry);
}
