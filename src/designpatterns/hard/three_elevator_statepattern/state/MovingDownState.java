package designpatterns.hard.three_elevator_statepattern.state;

import designpatterns.hard.three_elevator_statepattern.data.Direction;
import designpatterns.hard.three_elevator_statepattern.data.Floor;
import designpatterns.hard.three_elevator_statepattern.data.Move;
import designpatterns.hard.three_elevator_statepattern.elevator.Elevator;

public class MovingDownState implements ElevatorState{
    private final Elevator elevator;

    public MovingDownState(Elevator elevator) {
        this.elevator = elevator;
    }
    @Override
    public void destine(Floor floor, Direction direction) {
        this.elevator.getMoveStore().addMove(new Move(floor, direction));
        Direction topDirection = this.elevator.getMoveStore().getTop().get().getDirection();
        if(topDirection.equals(Direction.UP))
            this.elevator.setElevatorState(new MovingDownState(elevator));
    }

    @Override
    public void open(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void close(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void stop(Floor floor) {
        this.elevator.getMoveStore().clearTop();
        this.elevator.setElevatorState(new IdleState(elevator));
    }

    @Override
    public State getName() {
        return State.MOVINGDOWN;
    }
}
