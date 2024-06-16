package designpatterns.hard.three_elevator_statepattern.moves;

import designpatterns.hard.three_elevator_statepattern.data.Direction;
import designpatterns.hard.three_elevator_statepattern.data.Move;

import java.util.Optional;
import java.util.PriorityQueue;

public class UnidirectionalMoveStore implements MoveStore{

    private final PriorityQueue<Move> upMoves;
    private final PriorityQueue<Move> downMoves;
    private Direction currentDirection;

    public UnidirectionalMoveStore() {
        this.upMoves = new PriorityQueue<Move>(
                (f1,f2) -> f1.getDestinationFloor().getNumber() - f2.getDestinationFloor().getNumber()
        );

        this.downMoves = new PriorityQueue<Move>(
                (f1,f2) -> f2.getDestinationFloor().getNumber() - f1.getDestinationFloor().getNumber()
        );

        this.currentDirection = Direction.HALT;
    }

    @Override
    public void addMove(Move move) {
        if(this.upMoves.isEmpty() && this.downMoves.isEmpty()){
            this.currentDirection = move.getDirection();
        }
        if(move.getDirection().equals(Direction.UP))
            this.upMoves.add(move);
        else
            this.downMoves.add(move);
    }

    @Override
    public Optional<Move> getTop() {
        if(upMoves.isEmpty() && downMoves.isEmpty()){
            return Optional.empty();
        }
        if(currentDirection.equals(Direction.UP)) {
            return Optional.of(this.upMoves.peek());
        }
        return Optional.of(this.downMoves.peek());
    }

    @Override
    public void clearTop() {
        if(upMoves.isEmpty() && downMoves.isEmpty()){
            throw new RuntimeException("Illegal move");
        }
        if(this.currentDirection.equals(Direction.UP)){
            this.upMoves.poll();
            if(this.upMoves.isEmpty()){
                if(!this.downMoves.isEmpty()){
                    this.currentDirection = Direction.DOWN;
                }
                else
                    this.currentDirection = Direction.HALT;
            }
        } else {
            this.downMoves.poll();
            if(this.downMoves.isEmpty()){
                if(!this.upMoves.isEmpty()){
                    this.currentDirection = Direction.UP;
                }
                else this.currentDirection = Direction.HALT;
            }
        }
    }

    @Override
    public Direction getCurrectDirection() {
        return this.currentDirection;
    }
}
