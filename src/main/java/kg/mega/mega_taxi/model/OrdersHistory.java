package kg.mega.mega_taxi.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Entity
@Table(name = "order_history")
@Component
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
    @JoinColumn(name = "order_status")
    private OrderStatus orderStatus;


    @Column(name = "price")
    private double price;
}
