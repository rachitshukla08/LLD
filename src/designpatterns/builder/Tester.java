package designpatterns.builder;

public class Tester {
    //Use cases:
    //Optional arguments
    //Immutability
    public static void main(String[] args) {
        User user = new User.Builder(2, "RS")
                .age(25)
                .phoneNumber("12356").build();
        User user2 = new User.Builder(3, "RT")
                .age(26).build();
    }
}
