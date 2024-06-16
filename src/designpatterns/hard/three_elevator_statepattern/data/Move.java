package designpatterns.hard.three_elevator_statepattern.data;

public class Move {
    private final Floor floor;
    private final Direction direction;

    public Move(Floor floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public Floor getDestinationFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}
