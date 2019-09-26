package uk.co.lewisvince.rediscaching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.lewisvince.rediscaching.model.Car;
import uk.co.lewisvince.rediscaching.repository.CarRepository;
import uk.co.lewisvince.rediscaching.repository.CarRepositoryCache;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;


    private final CarRepositoryCache carRepositoryCache;

    @Autowired
    public CarService(CarRepository carRepository, CarRepositoryCache carRepositoryCache) {
        this.carRepository = carRepository;
        this.carRepositoryCache = carRepositoryCache;
    }

    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    public Car addCar(Car car) {
        if (car.getLicensePlate() != null
                && car.getManufacturer() != null
                && car.getYearOfManufacture() > 1800) {
            return carRepository.addCar(car);
        }
        throw new RuntimeException("Car not found.");
    }


}
