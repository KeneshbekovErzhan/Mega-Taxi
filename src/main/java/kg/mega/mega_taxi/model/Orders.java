package kg.mega.mega_taxi.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Entity
@Table(name = "orders")
@Component
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

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
    @JoinColumn(name = "order_status", referencedColumnName = "status_name")
    private OrderStatus order_status;

    @Column(name = "price")
    private double price;

}
