package collok;
import java.util.ArrayList;

public interface Strategy {
    ArrayList<Car> getSortedArray(ArrayList<Car> original, int lowerBound, int upperBound);
}