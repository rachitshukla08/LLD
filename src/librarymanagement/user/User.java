package librarymanagement.user;

public abstract class User {
    private final int id;
    private final String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
