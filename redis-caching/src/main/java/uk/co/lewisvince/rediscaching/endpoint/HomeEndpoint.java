package uk.co.lewisvince.rediscaching.endpoint;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.co.lewisvince.rediscaching.model.Car;
import uk.co.lewisvince.rediscaching.service.CarService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HomeEndpoint {

    private final CarService carService;

    @Autowired
    public HomeEndpoint(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCars")
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    public List<Object> parse(String input) {
        List<Object> output = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(input);

        for (Object item : jsonArray) {
            if (item instanceof JSONArray) {
                output.add(parse((String) item));
            } else {
                output.add(item);
            }
        }
        return output;
    }
}
