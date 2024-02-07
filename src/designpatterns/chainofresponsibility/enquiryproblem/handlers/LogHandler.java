package designpatterns.chainofresponsibility.enquiryproblem.handlers;

import designpatterns.chainofresponsibility.enquiryproblem.data.EnquiryType;

public class LogHandler implements EnquiryHandler {
    private final EnquiryHandler nextHandler;

    public LogHandler(EnquiryHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public EnquiryType handle(String enquiry) {
        System.out.println(enquiry);
        EnquiryType enquiryType = nextHandler.handle(enquiry);
        // perform some actions of logging
        System.out.println("Log handler got the enquiry type: "+enquiryType);
        return enquiryType;
    }
}
