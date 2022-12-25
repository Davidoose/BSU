package collok;
import java.util.ArrayList;

public class FindStrategy implements Strategy{
    @Override
    public ArrayList<Car> getSortedArray(ArrayList<Car> original, int yearOfManufacture, int yearOfDisposal) {
        ArrayList<Car> sorted = new ArrayList<>();

        for (Car car : original){
            if (car.getYearOfManufacture() == yearOfManufacture && car.getYearOfDisposal() == yearOfDisposal){
                sorted.add(car);
            }
        }
        sorted.sort(Car::compareTo);
        return sorted;
    }
}
