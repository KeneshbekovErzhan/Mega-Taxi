package kg.mega.mega_taxi.controllers;


import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.request.SaveCar;
import kg.mega.mega_taxi.request.SaveUser;
import kg.mega.mega_taxi.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarsController {

    @Autowired
    private CarsService carsService;
    @PostMapping("/create")
    public ResponseEntity<?> saveCar(@RequestBody SaveCar saveCar){
        carsService.saveCar(saveCar);
        return ResponseEntity.ok("Car saved!");
    }

    @GetMapping("/getById/{id}")
    public Cars getById(@PathVariable Long id){
        return carsService.getCarById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCar(@RequestBody SaveCar saveCar, @PathVariable Long id){
        carsService.update(saveCar, id);
        return ResponseEntity.ok("Car updated");
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        carsService.deleteCar(id);
    }

    @GetMapping("/getAll")
    public List<Cars> getAll(@RequestParam ("name") String name){
        return carsService.getAllCars(name);
    }
}
