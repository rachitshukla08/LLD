package designpatterns.hard.three_elevator_statepattern.elevator;

import designpatterns.hard.three_elevator_statepattern.data.Direction;
import designpatterns.hard.three_elevator_statepattern.data.Floor;
import designpatterns.hard.three_elevator_statepattern.moves.MoveStore;
import designpatterns.hard.three_elevator_statepattern.state.ElevatorState;

public class Elevator {

    private Floor currentFloor;
    private ElevatorState elevatorState;
    private final MoveStore moveStore;

    public Elevator(MoveStore moveStore) {
        this.moveStore = moveStore;
    }

    public void destine(Floor floor, Direction direction){
        elevatorState.destine(floor,direction);
    }

    public void open(Floor floor) {
        elevatorState.open(floor);
    }

    public void close(Floor floor) {
        elevatorState.close(floor);
    }

    public void stop(Floor floor) {
        elevatorState.stop(floor);
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }
    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }
    public MoveStore getMoveStore() {
        return moveStore;
    }


}
