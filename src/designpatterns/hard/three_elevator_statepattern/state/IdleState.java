package designpatterns.hard.three_elevator_statepattern.state;

import designpatterns.hard.three_elevator_statepattern.data.Direction;
import designpatterns.hard.three_elevator_statepattern.data.Floor;
import designpatterns.hard.three_elevator_statepattern.data.Move;
import designpatterns.hard.three_elevator_statepattern.elevator.Elevator;

public class IdleState implements ElevatorState {
    private final Elevator elevator;

    public IdleState(Elevator elevator) {
        this.elevator = elevator;
    }
    @Override
    public void destine(Floor floor, Direction direction) {
        this.elevator.getMoveStore().addMove(new Move(floor, direction));
        Direction topDirection = this.elevator.getMoveStore().getTop().get().getDirection();
        if(topDirection.equals(Direction.UP))
            this.elevator.setElevatorState(new MovingUpState(elevator));
        else if(topDirection.equals(Direction.DOWN))
            this.elevator.setElevatorState(new MovingDownState(elevator));
        else
            throw new RuntimeException();
    }

    @Override
    public void open(Floor floor) {
        this.elevator.setElevatorState(new GateOpenState(elevator));
    }

    @Override
    public void close(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void stop(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public State getName() {
        return State.IDLE;
    }
}
