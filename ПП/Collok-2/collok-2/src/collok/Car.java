package collok;
public class Car implements Comparable<Car> {

    public String getCarModel() {
        return carModel;
    }

    private final String carModel;
    private final int price;
    private final int yearOfManufacture;
    private final int yearOfDisposal;

    public Car() {
        this.carModel = null;
        this.price = 0;
        this.yearOfManufacture = 1990;
        this.yearOfDisposal = 2000;
    }

    public Car(String name, int price, int lowerBound, int upperBound) throws IllegalArgumentException {
        if (!rightBound(lowerBound, upperBound))
            throw new IllegalArgumentException("the year of disposal is less than the year of manufacture");
        this.carModel = name;
        if (price >= 0)
            this.price = price;
        else throw new IllegalArgumentException("Negative price");
        if (lowerBound >= 0)
            this.yearOfManufacture = lowerBound;
        else throw new IllegalArgumentException("Negative year of manufacture");
        if (upperBound >= 0)
            this.yearOfDisposal = upperBound;
        else throw new IllegalArgumentException("Negative year of disposal");
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public int getYearOfDisposal() {
        return yearOfDisposal;
    }

    public static boolean rightBound(int first, int second) {
        return first <= second;
    }

    @Override
    public String toString() {
        return "carModel = '" + carModel + '\'' +
                ", price = " + price +
                ", ageFrom = " + yearOfManufacture +
                ", ageTo = " + yearOfDisposal;
    }

    @Override
    public int compareTo(Car o) {
        return price - o.price;
    }
}
