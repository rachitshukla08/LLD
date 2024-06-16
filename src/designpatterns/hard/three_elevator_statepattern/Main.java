package designpatterns.hard.three_elevator_statepattern;

import designpatterns.hard.three_elevator_statepattern.data.Direction;
import designpatterns.hard.three_elevator_statepattern.data.Floor;
import designpatterns.hard.three_elevator_statepattern.elevator.Elevator;
import designpatterns.hard.three_elevator_statepattern.moves.UnidirectionalMoveStore;
import designpatterns.hard.three_elevator_statepattern.state.IdleState;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(new UnidirectionalMoveStore());
        elevator.setElevatorState(new IdleState(elevator));
        elevator.setCurrentFloor(new Floor(0, "Ground"));
        elevator.destine(new Floor(4, "Fourth"), Direction.UP);
        System.out.println(elevator.getElevatorState().getName());
        elevator.destine(new Floor(7, "Seventh"), Direction.UP);
        elevator.setCurrentFloor(new Floor(1, "First"));
        elevator.setCurrentFloor(new Floor(2, "Second"));
        elevator.setCurrentFloor(new Floor(3, "Third"));
        elevator.destine(new Floor(1, "First"), Direction.DOWN);
        elevator.setCurrentFloor(new Floor(4, "Fourth"));
        elevator.stop(new Floor(4, "Fourth"));
        System.out.println(elevator.getElevatorState().getName());
        elevator.open(new Floor(4, "Fourth"));
        System.out.println(elevator.getElevatorState().getName());
        elevator.close(new Floor(4, "Fourth"));
        System.out.println(elevator.getElevatorState().getName());
    }
}
