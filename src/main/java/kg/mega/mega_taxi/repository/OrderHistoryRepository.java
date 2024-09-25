package kg.mega.mega_taxi.repository;

import kg.mega.mega_taxi.model.OrdersHistory;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrdersHistory, Long> {

}
