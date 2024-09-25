package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CarsService {

    @Autowired
    private Cars cars;

    @Autowired
    private CarRepository carRepository;


    public void saveCar(){
    }

    public Cars getCarById(){
        return cars;
    }

    public void deleteCar(){
    }

    public void update(){
    }

}
