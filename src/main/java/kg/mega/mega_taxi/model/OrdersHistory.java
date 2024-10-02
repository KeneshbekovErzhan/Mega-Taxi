package kg.mega.mega_taxi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "order_history")
@Component
@Data
public class OrdersHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderHistoryId;

    @Column(name = "source_point")
    private String sourcePoint;

    @Column(name = "destination_point")
    private String destinationPoint;

    @OneToOne
    @JoinColumn(name = "client_Id", referencedColumnName = "userId")
    private Users client;

    @OneToOne
    @JoinColumn(name = "driver_Id", referencedColumnName = "userId")
    private Users driver;

    @OneToOne
    @JoinColumn(name = "status_order")
    private OrderStatus statusOrder;

    @Column(name = "price")
    private double price;
}
