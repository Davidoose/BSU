package collok;
import java.util.ArrayList;

public class StreamFindStrategy implements Strategy {
    @Override
    public ArrayList<Car> getSortedArray(ArrayList<Car> original, int yearOfManufacture, int yearOfDisposal) {
        ArrayList<Car> sorted = new ArrayList<>();
        original.stream().filter((vehicle) -> vehicle.getYearOfManufacture() == yearOfManufacture && vehicle.getYearOfDisposal() == yearOfDisposal).
                sorted(Car::compareTo).forEach(sorted::add);
        return sorted;
    }
}
