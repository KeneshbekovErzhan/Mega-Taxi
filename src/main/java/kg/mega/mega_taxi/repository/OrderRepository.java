package kg.mega.mega_taxi.repository;

import kg.mega.mega_taxi.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
