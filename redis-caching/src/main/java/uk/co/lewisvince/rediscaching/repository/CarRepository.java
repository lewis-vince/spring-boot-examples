package uk.co.lewisvince.rediscaching.repository;

import org.springframework.stereotype.Repository;
import uk.co.lewisvince.rediscaching.model.Car;

import java.util.Arrays;
import java.util.List;

@Repository
public class CarRepository {

    private final List<Car> cars = Arrays.asList(
            new Car("Vauxhall", "TB23 TOD", 1997),
            new Car("VW", "JH76 OPP", 2007),
            new Car("Jeep", "DJ44 ROO", 2011)
    );

    public List<Car> getAllCars() {
        return cars;
    }

    public Car addCar(Car car) {
        cars.add(car);
        return car;
    }
}
