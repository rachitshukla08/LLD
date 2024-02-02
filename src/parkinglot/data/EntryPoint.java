package parkinglot.data;

public class EntryPoint {
    private final String name;
    private Boolean isOpen;

    public EntryPoint(String name, Boolean isOpen) {
        this.name = name;
        this.isOpen = isOpen;
    }

    public String getName() {
        return name;
    }

    public Boolean getOpen() {
        return isOpen;
    }
}
