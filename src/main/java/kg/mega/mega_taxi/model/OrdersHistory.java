package kg.mega.mega_taxi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_history")
public class OrdersHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "source_point")
    private String sourcePoint;

    @Column(name = "destination_point")
    private String destinationPoint;

    @ManyToOne
    @JoinColumn(name = "id")
    private Users client;

    @ManyToOne
    @JoinColumn(name = "id")
    private Users driver;

    @ManyToOne
    @JoinColumn(name = "id")
    private OrderStatus orderStatus;

    @Column(name = "price")
    private double price;
}
