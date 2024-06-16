package designpatterns.hard.three_elevator_statepattern.data;

public class Floor {
    private final int number;
    private final String name;

    public Floor(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
