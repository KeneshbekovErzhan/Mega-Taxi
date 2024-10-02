package kg.mega.mega_taxi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Entity
@Table(name = "orders")
@Data
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
    @JoinColumn(name = "status_order")
    private OrderStatus starusOrder;

    @Column(name = "price")
    private double price;

}
