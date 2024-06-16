package designpatterns.hard.three_elevator_statepattern.moves;

import designpatterns.hard.three_elevator_statepattern.data.Direction;
import designpatterns.hard.three_elevator_statepattern.data.Move;

import java.util.Optional;

public interface MoveStore {
    void addMove(Move move);
    Optional<Move> getTop();
    void clearTop();
    Direction getCurrectDirection();

}
