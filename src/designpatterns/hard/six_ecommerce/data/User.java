package designpatterns.hard.six_ecommerce.data;

public class User {
    private final int id;
    private final String name;
    private final String email;
    private final String phoneNo;

    public User(int id, String name, String email, String phoneNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }
}
