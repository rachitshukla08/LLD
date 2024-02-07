package designpatterns.chainofresponsibility.enquiryproblem;

public class Tester {
    public static void main(String[] args) {
        new HandleEnquiryAPI().handleEnquiry("I want to create Account");
        new HandleEnquiryAPI().handleEnquiry("I want to create React project");
        new HandleEnquiryAPI().handleEnquiry("I want to go for a walk");
    }
}
