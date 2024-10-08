package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.model.Users;
import kg.mega.mega_taxi.repository.CarRepository;
import kg.mega.mega_taxi.repository.UsersRepository;
import kg.mega.mega_taxi.request.SaveCar;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarsService {


    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UsersRepository usersRepository;

    public void saveCar(SaveCar saveCar){
        Cars cars = new Cars();
        cars.setBrand(saveCar.getBrand());
        cars.setModel(saveCar.getModel());
        cars.setColor(saveCar.getColor());
        cars.setNumberSheet(saveCar.getNumberSheet());
        Users user = usersRepository.getReferenceById(saveCar.getIdUsers());
        cars.setIdUsers(user);
        carRepository.save(cars);
    }

    public Cars getCarById(Long id){
       return carRepository.findById(id).orElse(null);
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

    public void update(SaveCar saveCar, Long id){
        Cars carsToUpdate = carRepository.findById(id).orElse(null);
        if(carsToUpdate != null){
            Cars cars1 = new Cars();
            cars1.setBrand(saveCar.getBrand());
            cars1.setModel(saveCar.getModel());
            cars1.setColor(saveCar.getColor());
            cars1.setNumberSheet(saveCar.getNumberSheet());
            Users user = usersRepository.getReferenceById(Long.valueOf(saveCar.getIdUsers()));
            cars1.setIdUsers(user);
            carRepository.save(cars1);
        }
    }

    public List<Cars> getAllCars(String filter){
        if (filter == null || filter.isEmpty()){
            return carRepository.findAll();
        }
        return carRepository.findAll().stream()
                .filter(car2 -> {
                    val userId = car2.getIdUsers().getUserId();
                            return car2.getBrand().equals(filter)||car2.getModel().equals(filter)||car2.getColor().equals(filter)
                                    ||car2.getNumberSheet().equals(filter)|| userId.equals(filter);
                        }
                ).toList();
    }

}
