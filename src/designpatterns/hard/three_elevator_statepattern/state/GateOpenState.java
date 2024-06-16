package designpatterns.hard.three_elevator_statepattern.state;

import designpatterns.hard.three_elevator_statepattern.data.Direction;
import designpatterns.hard.three_elevator_statepattern.data.Floor;
import designpatterns.hard.three_elevator_statepattern.elevator.Elevator;

public class GateOpenState implements ElevatorState{
    private final Elevator elevator;

    public GateOpenState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destine(Floor floor, Direction direction) {
        throw new RuntimeException();
    }

    @Override
    public void open(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void close(Floor floor) {
        Direction direction = this.elevator.getMoveStore().getCurrectDirection();
        if(direction.equals(Direction.UP))
            this.elevator.setElevatorState(new MovingDownState(elevator));
        else if(direction.equals(Direction.DOWN))
            this.elevator.setElevatorState(new MovingDownState(elevator));
        else if(direction.equals(Direction.HALT))
            this.elevator.setElevatorState(new IdleState(elevator));
        else
            throw new RuntimeException();
    }

    @Override
    public void stop(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public State getName() {
        return State.GATEOPEN;
    }
}
