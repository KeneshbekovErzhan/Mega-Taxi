package kg.mega.mega_taxi.repository;

import kg.mega.mega_taxi.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
}
