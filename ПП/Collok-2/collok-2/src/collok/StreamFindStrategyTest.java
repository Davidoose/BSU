package collok;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StreamFindStrategyTest {

    ArrayList<Car> cars = new ArrayList<>();
    @Test
    void getSortedArray() {
            Car car1 = new Car("Reno", 20000 ,2005, 2022);
            Car car2 = new Car("Opel", 15000, 2000, 2021);
            Car car3 = new Car("Geely", 10000, 2015, 2023);
            cars.add(car1);
            cars.add(car2);
            cars.add(car3);
        }
}