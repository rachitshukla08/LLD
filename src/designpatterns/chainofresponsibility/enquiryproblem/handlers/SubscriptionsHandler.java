package designpatterns.chainofresponsibility.enquiryproblem.handlers;

import designpatterns.chainofresponsibility.enquiryproblem.data.EnquiryType;

public class SubscriptionsHandler implements EnquiryHandler {
    private final EnquiryHandler nextHandler;

    public SubscriptionsHandler(EnquiryHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public EnquiryType handle(String enquiry) {
        System.out.println("Trying to process query through subscriptions handler");
        if(enquiry.contains("Account")||enquiry.contains("Fees")){
            // Take actions
            return EnquiryType.SUBSCRIPTIONS;
        }
        return nextHandler.handle(enquiry);
    }
}
