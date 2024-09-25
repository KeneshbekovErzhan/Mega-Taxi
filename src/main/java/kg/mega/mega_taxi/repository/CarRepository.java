package kg.mega.mega_taxi.repository;

import kg.mega.mega_taxi.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Cars, Long> {

}
