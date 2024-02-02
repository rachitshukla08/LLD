package parkinglot.factory;

import parkinglot.data.EntryPoint;
import parkinglot.selector.NearestSelector;
import parkinglot.selector.ParkingSpotSelector;
import parkinglot.selector.RandomSelector;

public class SpotSelectorFactory {
    private SpotSelectorFactory(){}

    public static ParkingSpotSelector getNearestSelector(EntryPoint entryPoint){
        return new NearestSelector(entryPoint);
    }

    public static ParkingSpotSelector getRandomSelector(){
        return new RandomSelector();
    }
}
