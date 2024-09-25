package kg.mega.mega_taxi.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Entity
@Table(name = "order_status")
@Component
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderStatusId;

    @Column(name = "status_name")
    private String statusName;
}
