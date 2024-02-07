package designpatterns.chainofresponsibility.enquiryproblem.handlers;

import designpatterns.chainofresponsibility.enquiryproblem.data.EnquiryType;

public class ProjectEnquiryHandler implements EnquiryHandler {
    private final EnquiryHandler nextHandler;

    public ProjectEnquiryHandler(EnquiryHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public EnquiryType handle(String enquiry) {
        System.out.println("Trying to process query through project handler");
        if(enquiry.contains("React")||enquiry.contains("Fullstack")){
            // Take actions
            return EnquiryType.PROJECTS;
        }
        return nextHandler.handle(enquiry);
    }
}
