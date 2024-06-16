package designpatterns.hard.three_elevator_statepattern.state;

import designpatterns.hard.three_elevator_statepattern.data.Direction;
import designpatterns.hard.three_elevator_statepattern.data.Floor;

public interface ElevatorState {

    void destine(Floor floor, Direction direction);

    void open(Floor floor);

    void close(Floor floor);

    void stop(Floor floor);

    State getName();

}
